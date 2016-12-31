package com.company;
public class Solution
{
    public String convert(String s, int numRows)
    {
        if (1 == numRows)
        {
            return s;
        }

        int numCols = calCols(numRows, s.length()) + 1;

        char[][] array = new char[numRows][numCols];

        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numCols; j++)
            {
                array[i][j] = ' ';
            }
        }
        int row = 0;
        int col = 0;
        boolean rowFlag = true;//true时为增加，false时为减少
        for (int i = 0; i < s.length(); i++)
        {
            array[row][col] = s.charAt(i);
            if (rowFlag)
            {
                row ++;
                if(row > numRows -1)
                {
                    rowFlag = false;
                    row = numRows - 2;
                    col += 1;
                }
            }
            else
            {
                row --;
                col ++;
                if(row < 0)
                {
                    rowFlag = true;
                    row = 1;
                    col --;

                }
            }

        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numCols; j++)
            {
                if (' ' != array[i][j])
                {
                    builder.append(array[i][j]);
                }
            }

        }
        return builder.toString();
    }

    //计算所需要的总的列数
    private int calCols(int numRows, int index)
    {
        int left = index % (2 * numRows -2);
        int col = index /(2 * numRows - 2) * (numRows - 1);

        int add;
        if(left < numRows)
        {
            add = 0;
        }
        else
        {
            add = left - numRows + 1;
        }
        return col + add;
    }

}