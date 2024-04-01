import * as firebase from "firebase/app";
import * as firebaseAuth from "firebase/auth";
import { browserLocalPersistence } from "firebase/auth";

const firebaseConfig = {
    apiKey: "AIzaSyCzBP0sZm_ylhmADySFa1B-AsIjz8UcZDg",
    authDomain: "mimus-s-pet.firebaseapp.com",
    projectId: "mimus-s-pet",
    storageBucket: "mimus-s-pet.appspot.com",
    messagingSenderId: "108252392432",
    appId: "1:108252392432:web:e49972188603631fa04b35"
  };
  
  const app = firebase.initializeApp(firebaseConfig);
  
  export const auth = firebaseAuth.initializeAuth(app, {
    persistence: browserLocalPersistence
  });