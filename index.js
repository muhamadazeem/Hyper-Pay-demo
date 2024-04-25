/**
 * @format
 */
import React from 'react'
import {AppRegistry,I18nManager} from 'react-native';
import {name as appName} from './app.json';
import App from './source/App';
import {Configure} from './source/redux/Store';
import {Provider} from 'react-redux';



const store = Configure();

const AppNav = () => {
    return (
      <Provider store={store}>
        <App />
      </Provider>
    );
  };

AppRegistry.registerComponent(appName, () => AppNav);
