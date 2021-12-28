{
        int i;

public String decodeString(String s) {
        StringBuilder currentStr = new StringBuilder();
        int currentTimes = 0;

        while(i < s.length())
        {
        char curr = s.charAt(i);

        if(Character.isDigit(curr)) {
        currentTimes = currentTimes * 10 + curr - '0';
        i++;
        } else if (curr == '[') {
        i++;
        String devStr = decodeString(s);

        StringBuilder newStr = new StringBuilder();
        for(int c = 1; c <= currentTimes; c++) {
        newStr.append(devStr);
        }

        currentStr.append(newStr);
        currentTimes = 0;
        } else if (curr == ']') {
        i++;
        return currentStr.toString();
        } else {
        i++;
        currentStr.append(curr);
        }
        }

        return currentStr.toString();
        }
        }