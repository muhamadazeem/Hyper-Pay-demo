/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, {   } from 'react';
import {
  View, Keyboard,
  TouchableWithoutFeedback,
  StyleSheet,
  TextInput,
  Dimensions,
  Text
} from 'react-native';
const { width, height } = Dimensions.get('window');
import { connect } from 'react-redux';



const App = (props) => {











  return (

    <TouchableWithoutFeedback onPress={Keyboard.dismiss} accessible={false}>
      

    <>

      <View style={[styles.inputView, { flexDirection:  'row', marginTop: 48, marginLeft:20 }]}>


                <TextInput
                    // ref={emailRef}
                    style={[styles.inputText, { textAlign:  "right" , fontFamily:  'AvenirArabic-Book' }]}
                    placeholder={ 'email'}
                    placeholderTextColor="grey"
                    underlineColorAndroid="transparent"
                    keyboardType={'email-address'}
                    // value={email}
                    maxLength={50}
                    secureTextEntry={false}
                    importantForAutofill="no"

                />

              


            </View>

            <View style={{marginTop:20}}>
                                <Text style={{borderWidth:1, textAlign:'right', marginHorizontal:20}}>THis should be right</Text>

                </View>
       </>
    </TouchableWithoutFeedback>

  );
};


const styles = StyleSheet.create({
 
  inputView: {
      backgroundColor: '#FAFAFB', height: 64, width: '85%', borderWidth: 1, borderColor: '#E5E5F3', borderRadius: 16, flexDirection: 'row', justifyContent: 'center',

  },
  inputText: {
      flex: 1, paddingHorizontal: 15, color: '#000',
  }
});


const mapStateToProps = state => {

  return {
  }
};
export default connect(mapStateToProps,{}) (App);
