package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SupsdInfoChanger {
    public static String addSuperSedeInfoToIPLFigure(String iplFigure){
        ArrayList<String> stringArrayList = PreProcessing.getAllItemsOfFigure(iplFigure, "itemdata");
        int itemDataStart = PreProcessing.firstOccuranceOfTagInIPLFigure(iplFigure, "itemdata");
        int itemDataEnd = PreProcessing.lastOccuranceOfTagInIPLFigure(iplFigure, "itemdata");
        StringBuilder sb = new StringBuilder();
        sb.append(iplFigure.substring(0, itemDataStart));
        for(String itemdata: stringArrayList){
            sb.append(SupsdInfoChanger.addSupersedeInformationTagToItemdataTag(itemdata));
        }
        sb.append(iplFigure.substring(itemDataEnd+1, iplFigure.length()));
        return sb.toString();
    }
    public static String addSupersedeInformationTagToItemdataTag(String itemdataTag){
        int N = itemdataTag.length();
        int[] startAndEnd = PreProcessing.getStartAndEndIndexOfTag(itemdataTag, "msc");
        if(startAndEnd[0] == -1)
            return itemdataTag;
        String supersededInfoTag =
                getAllSupersedInfoFromAnMscTag(itemdataTag.substring(startAndEnd[0], startAndEnd[1]+1));

        StringBuilder sb = new StringBuilder();
        sb.append(itemdataTag.substring(0, startAndEnd[0]));
        sb.append(supersededInfoTag);
        sb.append(itemdataTag.substring(startAndEnd[1]+1, itemdataTag.length()));
        return sb.toString();
    }
    public static String getAllSupersedInfoFromAnMscTag(String input){
        List<String> resultList = new ArrayList<>();
        String regex = "\\(([^)]*)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            resultList.add(matcher.group(1));
        }
        StringBuilder sb = new StringBuilder();
        for(String s: resultList){
            if(s.contains("SUPSD BY")){
                sb.append("<sd>"+ s.substring(9, s.length())+"</sd>");
            }
            else if(s.contains("SUPSDS"))
                sb.append("<sdes>"+ s.substring(7, s.length())+"</sdes>");
        }

        return sb.toString();

    }

}
