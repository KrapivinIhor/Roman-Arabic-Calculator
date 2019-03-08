package com.company.calc;


class RomanToArabicConverter {

    private int value(char romanNumber){
        if (romanNumber == 'I')
            return 1;
        if (romanNumber == 'V')
            return 5;
        if (romanNumber == 'X')
            return 10;
        if (romanNumber == 'L')
            return 50;
        if (romanNumber == 'C')
            return 100;
        if (romanNumber == 'D')
            return 500;
        if (romanNumber == 'M')
            return 1000;
        return -1;
    }

    int romanToDecimal(String romanSymbol){
        // Initialize result
        int result = 0;

        for (int i=0; i<romanSymbol.length(); i++)
        {
            // Getting value of symbol s[i]
            int firstSymbol = value(romanSymbol.charAt(i));
            // Getting value of symbol s[i+1]
            if (i+1 <romanSymbol.length())
            {
                int secondSymbol = value(romanSymbol.charAt(i+1));

                // Comparing both values
                if (firstSymbol >= secondSymbol){
                    // Value of current symbol is greater
                    // or equalto the next symbol
                    result = result + firstSymbol;
                } else {
                    result = result + secondSymbol - firstSymbol;
                    i++; // Value of current symbol is
                    // less than the next symbol
                }
            } else {
                result = result + firstSymbol;
                i++;
            }
        }
        return result;
    }
}


