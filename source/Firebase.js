import firebase from '@react-native-firebase/app'
import analytics from '@react-native-firebase/analytics';

const FirebaseConfig = firebase.initializeApp({
    // config options
    debug: true,
    persistence: true,
    apiKey: "",
    storageBucket: ""
  });


  export async function  firebaseRecordScreenVisit(page){
    
      await analytics().logScreenView({
        screen_name: page,
        screen_class: page,
      });     
    
  };

  export async function firebaseRecordEvent(event, data){
    
    await analytics().logEvent(event, data);
  
};
export async function setAnalyticsUserIdentity(id) {
    await analytics().setUserId(""+id)
  
}

  export default FirebaseConfig;