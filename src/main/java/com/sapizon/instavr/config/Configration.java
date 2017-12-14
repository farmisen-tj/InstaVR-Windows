package com.sapizon.instavr.config;

public class Configration {
	
	public static String testsite = "https://console.instavr.co/login"; 
	
	//instaVR login page
	public static final String username="username";
	public static final String password="//input[@type='password']";
	public static final String signin="html/body/div[3]/div/form/button";

	
	//instaVR Web DashBoard 
	public static final String Authoring ="//*[@id=\"sidebar-0\"]/a/h5";
	public static final String Branding ="//*[@id=\"sidebar-1\"]/a";
	public static final String Preview ="//*[@id=\"sidebar-5\"]/a";
	public static final String Packages ="//*[@id=\"sidebar-3\"]/a";
	public static final String Downloads ="//*[@id=\"sidebar-4\"]/a";

	
	//Selecting_Content_From_Frame
	public static final String selectElement ="//button[@class='btn btn-success btn-block  rounded ng-binding']";
	
	
	//Authoring_Add_VR_contents
	public static final String AddVRcontent ="//*[@id=\"instavr-content\"]/div/div/div[1]/div/div[1]/ul/li[4]/a/span";
	
	//Tour1
	public static final String icon1 ="//*[@id=\"media-list-dnd-0\"]/a[1]/img";
	public static final String icon2 ="//*[@id=\"media-list-dnd-1\"]/a[1]/img";
	public static final String icon3 ="//*[@id=\"media-list-dnd-2\"]/a[1]/img";


	//InstaVR_Seen_Properties
	public static final String addLink ="//*[@id=\"add-link\"]/a";
	public static final String addHotspot ="//*[@id=\"add-hotspot\"]/a";
	public static final String actions ="//*[@id=\"add-action\"]/a";

	//ManagingScene
	public static final String RestCam ="//*[@id=\"property-media-preview\"]/a";
	public static final String RemoveScene ="//*[@id=\"instavr-content\"]/div/div/div[3]/div/ul/li/span[8]/a[2]";
	public static final String UpdateScene ="//*[@id=\"instavr-content\"]/div/div/div[3]/div/div[1]/div[2]/div/div/div[1]/div/div[3]/div[1]/a";
	public static final String Reset="//*[@id=\"instavr-content\"]/div/div/div[3]/div/div[1]/div[2]/div/div[1]/div[1]/div/div[3]/div[5]/div[2]/a";
	public static final String SliderValue ="//*[@id=\"instavr-content\"]/div/div/div[3]/div/div[1]/div[2]/div/div[1]/div[1]/div/div[3]/div[5]/div[3]/input";	
	
	//instavrWebDashboard_Add_VR_contents
	public static final String Aut ="//*[@id=\"sidebar-0\"]/a/h5";

	//Upload_add_VR_image
	public static final String upload ="//*[@id=\"files-modal-body\"]/div[2]/div[1]";

	//Upload_done
	public static final String ok ="/html/body/div[125]/div/div/div[3]/div[2]/button[2]";
	
	//InstaVR_logout
	public static final String dropdown ="//a[@class='navbar-btn dropdown-toggle clear ng-binding']";
	public static final String logout ="//a[@href='/logout']";

	//T011
	public static final String Invalid ="/html/body/div[3]/div/form/div[1]";
	
	//T013
	public static final String Assert ="//*[@id=\"instavr-content\"]/div/div/div[3]/div/div[2]/div[1]/div[2]/a[1]";
	public static final String Assert1 ="//a[@class='btn btn-block btn-default rounded ng-binding']";

}
