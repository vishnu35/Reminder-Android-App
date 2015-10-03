package com.sktekki.reminder;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.preference.PreferenceManager;

public class Preferences {

	private static final String P_CURRENT_VERSION = "cv";

	/**
	 * Helper to write to editor if key specified is null
	 * 
	 * @param prefs
	 * @param editor
	 * @param r
	 * @param keyResource
	 * @param value
	 */
	public static void setIfUnset(SharedPreferences prefs, Editor editor,
			Resources r, int keyResource, int value) {
		String key = r.getString(keyResource);
		if (!prefs.contains(key))
			editor.putString(key, Integer.toString(value));
	}

	/**
	 * Helper to write to editor if key specified is null
	 * 
	 * @param prefs
	 * @param editor
	 * @param r
	 * @param keyResource
	 * @param value
	 */
	public static void setIfUnset(SharedPreferences prefs, Editor editor,
			Resources r, int keyResource, boolean value) {
		String key = r.getString(keyResource);
		if (!prefs.contains(key))
			editor.putBoolean(key, value);
	}

	/*
	 * ======================================================================
	 * ========================================================= system prefs
	 * ======================================================================
	 */

	/** CurrentVersion: the currently installed version of Astrid */
	public static int getCurrentVersion() {
		Context context = ContextManager.getContext();
		return getPrefs(context).getInt(P_CURRENT_VERSION, 0);
	}

	/** CurrentVersion: the currently installed version of Astrid */
	public static void setCurrentVersion(int version) {
		Context context = ContextManager.getContext();
		Editor editor = getPrefs(context).edit();
		editor.putInt(P_CURRENT_VERSION, version);
		editor.commit();
	}

	/*
	 * ======================================================================
	 * ======================================================= helper methods
	 * ======================================================================
	 */

	/** Get preferences object from the context */
	public static SharedPreferences getPrefs(Context context) {
		context = context.getApplicationContext();
		return PreferenceManager.getDefaultSharedPreferences(context);
	}

	// --- preference fetching (string)

	/**
	 * Gets an string value from a string preference. Returns null if the value
	 * is not set
	 * 
	 * @param context
	 * @param key
	 * @return integer value, or null on error
	 */
	public static String getStringValue(String key) {
		Context context = ContextManager.getContext();
		return getPrefs(context).getString(key, null);
	}

	/**
	 * Gets an string value from a string preference. Returns null if the value
	 * is not set
	 * 
	 * @param context
	 * @param key
	 * @return integer value, or null on error
	 */
	public static String getStringValue(int keyResource) {
		Context context = ContextManager.getContext();
		return getPrefs(context).getString(
				context.getResources().getString(keyResource), null);
	}

	/**
	 * Gets an integer value from a string preference. Returns null if the value
	 * is not set or not an integer.
	 * 
	 * @param keyResource
	 *            resource from string.xml
	 * @return integer value, or null on error
	 */
	public static int getIntegerFromString(int keyResource, int defaultValue) {
		Context context = ContextManager.getContext();
		Resources r = context.getResources();
		String value = getPrefs(context).getString(r.getString(keyResource),
				null);
		if (value == null)
			return defaultValue;

		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * Gets an float value from a string preference. Returns null if the value
	 * is not set or not an flat.
	 * 
	 * @param keyResource
	 *            resource from string.xml
	 * @return
	 */
	public static Float getFloatFromString(int keyResource) {
		Context context = ContextManager.getContext();
		Resources r = context.getResources();
		String value = getPrefs(context)
				.getString(r.getString(keyResource), ""); //$NON-NLS-1$

		try {
			return Float.parseFloat(value);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Sets string preference
	 */
	public static void setString(int keyResource, String newValue) {
		Context context = ContextManager.getContext();
		setString(context.getString(keyResource), newValue);
	}

	/**
	 * Sets string preference
	 */
	public static void setString(String key, String newValue) {
		Context context = ContextManager.getContext();
		Editor editor = getPrefs(context).edit();
		editor.putString(key, newValue);
		editor.commit();
	}

	/**
	 * Sets string preference from integer value
	 */
	public static void setStringFromInteger(int keyResource, int newValue) {
		Context context = ContextManager.getContext();
		Editor editor = getPrefs(context).edit();
		editor.putString(context.getString(keyResource), Integer
				.toString(newValue));
		editor.commit();
	}

	// --- preference fetching (boolean)

	/**
	 * Gets a boolean preference (e.g. a CheckBoxPreference setting)
	 * 
	 * @param key
	 * @param defValue
	 * @return default if value is unset otherwise the value
	 */
	public static boolean getBoolean(String key, boolean defValue) {
		Context context = ContextManager.getContext();
		return getPrefs(context).getBoolean(key, defValue);
	}

	/**
	 * Sets boolean preference
	 * 
	 * @param key
	 * @param value
	 */
	public static void setBoolean(String key, boolean value) {
		Context context = ContextManager.getContext();
		Editor editor = getPrefs(context).edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	// --- preference fetching (int)

	/**
	 * Gets a int preference
	 * 
	 * @param key
	 * @param defValue
	 * @return default if value is unset otherwise the value
	 */
	public static int getInt(String key, int defValue) {
		Context context = ContextManager.getContext();
		return getPrefs(context).getInt(key, defValue);
	}

	/**
	 * Sets int preference
	 * 
	 * @param key
	 * @param value
	 */
	public static void setInt(String key, int value) {
		Context context = ContextManager.getContext();
		Editor editor = getPrefs(context).edit();
		editor.putInt(key, value);
		editor.commit();
	}

	// --- preference fetching (long)

	/**
	 * Gets a long preference
	 * 
	 * @param key
	 * @param defValue
	 * @return default if value is unset otherwise the value
	 */
	public static long getLong(String key, long defValue) {
		Context context = ContextManager.getContext();
		return getPrefs(context).getLong(key, defValue);
	}

	/**
	 * Sets long preference
	 * 
	 * @param key
	 * @param value
	 */
	public static void setLong(String key, long value) {
		Context context = ContextManager.getContext();
		Editor editor = getPrefs(context).edit();
		editor.putLong(key, value);
		editor.commit();
	}

}
