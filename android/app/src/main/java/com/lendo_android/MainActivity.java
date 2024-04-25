package com.lendo.sa;

import com.clevertap.android.sdk.CleverTapAPI;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactActivityDelegate;
import com.clevertap.react.CleverTapModule;
import com.lendo_android.NotificationUtils;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.os.Build;

public class MainActivity extends ReactActivity {

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */

  // Override onStart:
  @Override
  protected void onStart() {
      super.onStart();
  }

 @Override
 public void onNewIntent(final Intent intent) {
       super.onNewIntent(intent);
       
       /**
        * On Android 12, clear notification on CTA click when Activity is already running in activity backstack
        */
       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
           CleverTapAPI.getDefaultInstance(getApplicationContext()).pushNotificationClickedEvent(intent.getExtras());

       }

   }

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(null);
        CleverTapModule.setInitialUri(getIntent().getData());
    }

  @Override
  protected String getMainComponentName() {
    return "mobile_client";
  }
  /**
   * Returns the instance of the {@link ReactActivityDelegate}. Here we use a util class {@link
   * DefaultReactActivityDelegate} which allows you to easily enable Fabric and Concurrent React
   * (aka React 18) with two boolean flags.
   */
  @Override
  protected ReactActivityDelegate createReactActivityDelegate() {
    return new DefaultReactActivityDelegate(
        this,
        getMainComponentName(),
        // If you opted-in for the New Architecture, we enable the Fabric Renderer.
        DefaultNewArchitectureEntryPoint.getFabricEnabled());
  }
}
