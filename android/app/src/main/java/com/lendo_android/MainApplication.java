package com.lendo.sa;

import android.app.Application;

import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactNativeHost;
import com.facebook.soloader.SoLoader;
import java.util.List;
import com.babisoft.ReactNativeLocalization.ReactNativeLocalizationPackage;  
import com.imagepicker.ImagePickerPackage;
import com.lendo.sa.HyperpayPackage;
import com.ocetnik.timer.BackgroundTimerPackage;
import com.oblador.keychain.KeychainPackage;
import io.invertase.firebase.messaging.ReactNativeFirebaseMessagingPackage;
import io.xogus.reactnative.versioncheck.RNVersionCheckPackage;
 import com.github.wumke.RNExitApp.RNExitAppPackage;
 import com.uxcam.RNUxcamPackage;
import com.clevertap.android.sdk.ActivityLifecycleCallback;
import com.clevertap.react.CleverTapPackage;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.react.CleverTapApplication;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost =
      new DefaultReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
          return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
          @SuppressWarnings("UnnecessaryLocalVariable")
          List<ReactPackage> packages = new PackageList(this).getPackages();
          // Packages that cannot be autolinked yet can be added manually here, for example:
          // packages.add(new MyReactNativePackage());
          new ReactNativeLocalizationPackage();
          new ReactNativeFirebaseMessagingPackage();
          new ImagePickerPackage();
          new BackgroundTimerPackage();
          new KeychainPackage();
          new RNVersionCheckPackage();
          new RNUxcamPackage();
           new RNExitAppPackage();
           packages.add(new HyperpayPackage());
          return packages;
        }

        @Override
        protected String getJSMainModuleName() {
          return "index";
        }

           @Override
        protected boolean isNewArchEnabled() {
          return BuildConfig.IS_NEW_ARCHITECTURE_ENABLED;
        }
        @Override
        protected Boolean isHermesEnabled() {
          return BuildConfig.IS_HERMES_ENABLED;
        }
      };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
    

    if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
      // If you opted-in for the New Architecture, we load the native entry point for this app.
      DefaultNewArchitectureEntryPoint.load();
    }
    ReactNativeFlipper.initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
  }
}
