package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class SMSSpam {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        Map<Character, String> buttonToCharacterList = new HashMap<>();
        buttonToCharacterList.put('1', "abc");
        buttonToCharacterList.put('2', "def");
        buttonToCharacterList.put('3', "ghi");
        buttonToCharacterList.put('4', "jkl");
        buttonToCharacterList.put('5', "mno");
        buttonToCharacterList.put('6', "pqr");
        buttonToCharacterList.put('7', "stu");
        buttonToCharacterList.put('8', "vwx");
        buttonToCharacterList.put('9', "yz");
        buttonToCharacterList.put('0', ".,!");

        char[] s = in.readLine(false).trim().toCharArray();

        int ans = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') ans++;
            else for (char posAns : buttonToCharacterList.keySet()) {
                String value = buttonToCharacterList.get(posAns);
                int pos = value.indexOf((s[i]));
                if (pos != -1) {
                    ans += pos + 1;
                    break;
                }
            }
        }

        out.println(ans);


    }
}