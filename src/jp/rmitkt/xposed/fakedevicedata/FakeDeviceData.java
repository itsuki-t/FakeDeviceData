package jp.rmitkt.xposed.fakedevicedata;

import android.app.Activity;

import de.robv.android.xposed.*;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import de.robv.android.xposed.XposedBridge;

public class FakeDeviceData implements IXposedHookLoadPackage {
	private boolean DEBUG_MODE = false;
	private XSharedPreferences pref;
	private LoadPackageParam lpparam;

	@Override
	public void handleLoadPackage(final LoadPackageParam lpp) throws Throwable {
		pref = new XSharedPreferences(FakeDeviceData.class.getPackage().getName(), "pref");
		lpparam = lpp;

		try{
			XposedHelpers.findAndHookMethod((Class)Activity.class, "onResume", new XC_MethodHook(){
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					pref.reload();
				}
			});
		}catch (NoSuchMethodError e){
			XposedBridge.log("couldn't hook method " + "onResume");
		}

		if (pref.getBoolean(lpparam.packageName, false)){
			Class<?> classBuild = XposedHelpers.findClass("android.os.Build", lpp.classLoader);
			if(pref.getBoolean("fake_board_key", false) && !(pref.getString("fake_board_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:BOARD="+pref.getString("fake_board_value", ""));
				XposedHelpers.setStaticObjectField(classBuild, "BOARD" ,pref.getString("fake_board_value", ""));
			}
			if(pref.getBoolean("fake_bootloader_key", false) && !(pref.getString("fake_bootloader_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:BOOTLOADER="+pref.getString("fake_bootloader_value", ""));
				XposedHelpers.setStaticObjectField(classBuild, "BOOTLOADER" ,pref.getString("fake_bootloader_value", ""));
			}
			if(pref.getBoolean("fake_brand_key", false) && !(pref.getString("fake_brand_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:BRAND="+pref.getString("fake_brand_value", ""));
				XposedHelpers.setStaticObjectField(classBuild, "BRAND" ,pref.getString("fake_brand_value", ""));
			}
			if(pref.getBoolean("fake_cpu_abi_key", false) && !(pref.getString("fake_cpu_abi_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:CPU_ABI="+pref.getString("fake_cpu_abi_value", ""));
				XposedHelpers.setStaticObjectField(classBuild, "CPU_ABI" ,pref.getString("fake_cpu_abi_value", ""));
			}
			if(pref.getBoolean("fake_cpu_abi2_key", false) && !(pref.getString("fake_cpu_abi2_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:CPU_ABI2="+pref.getString("fake_cpu_abi2_value", ""));
				XposedHelpers.setStaticObjectField(classBuild, "CPU_ABI2" ,pref.getString("fake_cpu_abi2_value", ""));
			}
			if(pref.getBoolean("fake_device_key", false) && !(pref.getString("fake_device_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:DEVICE="+pref.getString("fake_device_value", ""));
				XposedHelpers.setStaticObjectField(classBuild, "DEVICE" ,pref.getString("fake_device_value", ""));
			}
			if(pref.getBoolean("fake_display_key", false) && !(pref.getString("fake_display_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:DISPLAY="+pref.getString("fake_display_value", ""));
				XposedHelpers.setStaticObjectField(classBuild, "DISPLAY" ,pref.getString("fake_display_value", ""));
			}
			if(pref.getBoolean("fake_fingerprint_key", false) && !(pref.getString("fake_fingerprint_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:FINGERPRINT="+pref.getString("fake_fingerprint_value", ""));
				XposedHelpers.setStaticObjectField(classBuild, "FINGERPRINT" ,pref.getString("fake_fingerprint_value", ""));
			}
			if(pref.getBoolean("fake_hardware_key", false) && !(pref.getString("fake_hardware_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:HARDWARE="+pref.getString("fake_hardware_value", ""));
				XposedHelpers.setStaticObjectField(classBuild, "HARDWARE" ,pref.getString("fake_hardware_value", ""));
			}
			if(pref.getBoolean("fake_host_key", false) && !(pref.getString("fake_host_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:HOST="+pref.getString("fake_host_value", ""));
				XposedHelpers.setStaticObjectField(classBuild, "HOST" ,pref.getString("fake_host_value", ""));
			}
			if(pref.getBoolean("fake_id_key", false) && !(pref.getString("fake_id_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:ID="+pref.getString("fake_id_value", ""));
				XposedHelpers.setStaticObjectField(classBuild, "ID" ,pref.getString("fake_id_value", ""));
			}
			if(pref.getBoolean("fake_manufacturer_key", false) && !(pref.getString("fake_manufacturer_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:MANUFACTURER="+pref.getString("fake_manufacturer_value", ""));
				XposedHelpers.setStaticObjectField(classBuild, "MANUFACTURER" ,pref.getString("fake_manufacturer_value", ""));
			}
			if(pref.getBoolean("fake_model_key", false) && !(pref.getString("fake_model_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:MODEL="+pref.getString("fake_model_value", ""));
				XposedHelpers.setStaticObjectField(classBuild, "MODEL" ,pref.getString("fake_model_value", ""));
			}
			if(pref.getBoolean("fake_product_key", false) && !(pref.getString("fake_product_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:PRODUCT="+pref.getString("fake_product_value", ""));
				XposedHelpers.setStaticObjectField(classBuild, "PRODUCT" ,pref.getString("fake_product_value", ""));
			}
			if(pref.getBoolean("fake_radio_key", false) && !(pref.getString("fake_radio_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:RADIO="+pref.getString("fake_radio_value", ""));
				XposedHelpers.setStaticObjectField(classBuild, "RADIO" ,pref.getString("fake_radio_value", ""));
			}
			if(pref.getBoolean("fake_tags_key", false) && !(pref.getString("fake_tags_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:TAGS="+pref.getString("fake_tags_value", ""));
				XposedHelpers.setStaticObjectField(classBuild, "TAGS" ,pref.getString("fake_tags_value", ""));
			}
			if(pref.getBoolean("fake_time_key", false) && (pref.getLong("fake_time_value", 0) != 0)){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:TIME="+pref.getLong("fake_time_value", 0));
				XposedHelpers.setStaticObjectField(classBuild, "TIME" ,pref.getLong("fake_time_value", 0));
			}
			if(pref.getBoolean("fake_type_key", false) && !(pref.getString("fake_type_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:TYPE="+pref.getString("fake_type_value", ""));
				XposedHelpers.setStaticObjectField(classBuild, "TYPE" ,pref.getString("fake_type_value", ""));
			}
			if(pref.getBoolean("fake_user_key", false) && !(pref.getString("fake_user_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:USER="+pref.getString("fake_user_value", ""));
				XposedHelpers.setStaticObjectField(classBuild, "USER" ,pref.getString("fake_user_value", ""));
			}

			Class<?> classBuild2 = XposedHelpers.findClass("android.os.Build.VERSION", lpp.classLoader);    	  
			if(pref.getBoolean("fake_codename_key", false) && !(pref.getString("fake_codename_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:CODENAME="+pref.getString("fake_codename_value", ""));
				XposedHelpers.setStaticObjectField(classBuild2, "CODENAME" ,pref.getString("fake_codename_value", ""));
			}
			if(pref.getBoolean("fake_incremental_key", false) && !(pref.getString("fake_incremental_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:INCREMENTAL="+pref.getString("fake_incremental_value", ""));
				XposedHelpers.setStaticObjectField(classBuild2, "INCREMENTAL" ,pref.getString("fake_incremental_value", ""));
			}
			if(pref.getBoolean("fake_release_key", false) && !(pref.getString("fake_release_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:RELEASE="+pref.getString("fake_release_value", ""));
				XposedHelpers.setStaticObjectField(classBuild2, "RELEASE" ,pref.getString("fake_release_value", ""));
			}
			if(pref.getBoolean("fake_sdk_key", false) && !(pref.getString("fake_sdk_value", "").equalsIgnoreCase(""))){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:SDK="+pref.getString("fake_sdk_value", ""));
				XposedHelpers.setStaticObjectField(classBuild2, "SDK" ,pref.getString("fake_sdk_value", ""));
			}
			if(pref.getBoolean("fake_sdk_int_key", false) && (pref.getInt("fake_sdk_int_value", 0) != 0)){
				if(DEBUG_MODE) XposedBridge.log("setStaticObjectField:SDK_INT="+pref.getInt("fake_sdk_int_value", 0));
				XposedHelpers.setStaticObjectField(classBuild2, "SDK_INT" ,pref.getInt("fake_sdk_int_value", 0));
			}
		}
	}
}