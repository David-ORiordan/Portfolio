import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Storage } from '@ionic/storage';
import { CountryListPage } from '../country-list/country-list';

@IonicPage()
@Component({
  selector: 'page-settings',
  templateUrl: 'settings.html',
})
export class SettingsPage {

  // variables for user input
  enteredNumber: number;
  minAge: number;
  maxAge: number; 
  storedCountryKey: number;

  constructor(public navCtrl: NavController, public navParams: NavParams, private storage: Storage) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad SettingsPage');
  }

  // get and assign storage variable
  ionViewWillEnter() {
    this.storage.get("storedEnteredNumber").then((val) => {
      this.enteredNumber = val;
    })

    this.storage.get("storedMinAge").then((val) => {
      this.minAge = val;
    })

    this.storage.get("storedMaxAge").then((val) => {
      this.maxAge = val;
    })

    this.storage.get("storedCountryKey").then((val) => {
      this.storedCountryKey = val;
    })
  }

  // if statement checks if user has input a country ID
  // if false, user is asked to enter a country ID
  // if true, the user's input values are set into storage and the Settings page is popped off the stack
  saveButton() { 
    if (this.enteredNumber == null || this.enteredNumber == undefined ) { 
      alert("Please enter a Country ID");
      this.storage.set("storedHiddenBoolean", true);
    } else {
      this.storage.set("storedEnteredNumber", this.enteredNumber);
      this.storage.set("storedCountryKey", this.enteredNumber - 1);
      this.storage.set("storedMinAge", this.minAge);
      this.storage.set("storedMaxAge", this.maxAge);
      this.storage.set("storedHiddenBoolean", false);
      (this.navCtrl.pop());
    }
  }

  // user can delete their stored data
  cancelButton() {
   if (confirm("Would you like to erase your stored data (Country ID, Minimum Age, Maximum Age)?"))
    {
      alert("Your stored data was erased.");
      this.storage.set("storedEnteredNumber", "");
      this.storage.set("storedCountryKey", "");
      this.storage.set("storedMinAge", "");
      this.storage.set("storedMaxAge", "");
      this.enteredNumber = null;
      this.maxAge = null;
      this.minAge = null;
      this.storage.set("storedHiddenBoolean", true);
    } else {
      alert("Your stored data was not erased.");
    }
  }

  // push Country List page to the top of the stack
  goToCountryList() {
    this.navCtrl.push(CountryListPage);
  }
  
}
