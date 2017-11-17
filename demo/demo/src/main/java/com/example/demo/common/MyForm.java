package com.example.demo.common;

import java.util.LinkedHashMap;
import java.util.Map;



public class MyForm{
	private String selectedValue;
	private String selectedSA;

	public Map<String,String> option(){
		Map<String,String> scrollbtns = new LinkedHashMap<>();
		scrollbtns.put("G001","居酒屋");
		scrollbtns.put("G002","ダイニングバー");
		scrollbtns.put("G003","創作料理");
		scrollbtns.put("G004","和食");
		scrollbtns.put("G005","洋食");
		scrollbtns.put("G006","イタリアン・フレンチ");
		scrollbtns.put("G007","中華");
		scrollbtns.put("G008","焼肉・韓国料理");
		scrollbtns.put("G009","アジアン");
		scrollbtns.put("G010","各国料理");
		scrollbtns.put("G011","カラオケ・パーティ");
		scrollbtns.put("G012","バー・カクテル");
		scrollbtns.put("G013","ラーメン");
		scrollbtns.put("G014","カフェ・スイーツ");
		scrollbtns.put("G015","その他グルメ");
		scrollbtns.put("G016","お好み焼き・もんじゃ・鉄板焼き");

		return scrollbtns;
	}
	public Map<String,String> areaSA(){
		Map<String,String> scrollbtns = new LinkedHashMap<>();
		scrollbtns.put("SA41","北海道");
		scrollbtns.put("SA51","青森");
		scrollbtns.put("SA54","秋田");
		scrollbtns.put("SA55","山形");
		scrollbtns.put("SA52","岩手");
		scrollbtns.put("SA53","宮城");
		scrollbtns.put("SA56","福島");
		scrollbtns.put("SA11","東京");
		scrollbtns.put("SA12","神奈川");
		scrollbtns.put("SA13","埼玉");
		scrollbtns.put("SA14","千葉");
		scrollbtns.put("SA16","栃木");
		scrollbtns.put("SA15","茨城");
		scrollbtns.put("SA17","群馬");
		scrollbtns.put("SA61","新潟");
		scrollbtns.put("SA65","山梨");
		scrollbtns.put("SA66","長野");
		scrollbtns.put("SA63","石川");
		scrollbtns.put("SA62","富山");
		scrollbtns.put("SA64","福井");
		scrollbtns.put("SA33","愛知");
		scrollbtns.put("SA31","岐阜");
		scrollbtns.put("SA32","静岡");
		scrollbtns.put("SA34","三重");
		scrollbtns.put("SA23","大阪");
		scrollbtns.put("SA24","兵庫");
		scrollbtns.put("SA22","京都");
		scrollbtns.put("SA21","滋賀");
		scrollbtns.put("SA25","奈良");
		scrollbtns.put("SA26","和歌山");
		scrollbtns.put("SA73","岡山");
		scrollbtns.put("SA74","広島");
		scrollbtns.put("SA71","鳥取");
		scrollbtns.put("SA72","島根");
		scrollbtns.put("SA75","山口");
		scrollbtns.put("SA82","香川");
		scrollbtns.put("SA81","徳島");
		scrollbtns.put("SA83","愛媛");
		scrollbtns.put("SA84","高知");
		scrollbtns.put("SA91","福岡");
		scrollbtns.put("SA92","佐賀");
		scrollbtns.put("SA93","長崎");
		scrollbtns.put("SA94","熊本");
		scrollbtns.put("SA95","大分");
		scrollbtns.put("SA96","宮崎");
		scrollbtns.put("SA97","鹿児島");
		scrollbtns.put("SA98","沖縄");

		return scrollbtns;
	}
	public String getSelectedValue() {
		return selectedValue;
	}
	public void setSelectedValue(String selectedValue) {
		this.selectedValue=selectedValue;
	}
	public String getSelectedSA() {
		return selectedSA;
	}
	public void setSelectedSA(String selectedSA) {
		this.selectedSA=selectedSA;
	}
}
