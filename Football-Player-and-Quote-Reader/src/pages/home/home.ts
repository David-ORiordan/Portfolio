import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { SettingsPage } from '../settings/settings';
import { RandomQuoteProvider } from '../../providers/random-quote/random-quote';
import { SoccerDataProvider } from '../../providers/soccer-data/soccer-data';
import { Storage } from '@ionic/storage';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  // variables for random quotes data
  author: string;
  content: string;
  tags: string[];
  text: string;

  // variables for country data
  countryData: any[];
  countryName: string;
  countryFlagCode: string;
  uppercaseCountryFlagCode: string;
  countryKey: number;
  countryID: number;

  // variable for player data
  playerData: any[];
  minAge: number;
  maxAge: number;

  // variable dictates what does and doesn't get displayed in home.html regarding country and player data
  hidden: boolean;

  constructor(public navCtrl: NavController, private rqp:RandomQuoteProvider, private sdp:SoccerDataProvider, private storage: Storage) {

  }

  // access random quote data from the provider 
  // set and get some storage variables
  ionViewDidLoad() {
    this.rqp.getRandomQuote().subscribe(data => {
      this.author = data.author;
      this.content = data.content;
      this.tags = data.tags;
    });
    this.storage.set("storedMinAge", "");
    this.storage.set("storedMaxAge", "");
    this.storage.get("storedHiddenBoolean").then((val) => {
    this.hidden = val;
    })
  }

  // get and assign hidden storage variable
  ionViewDidEnter() {
    this.storage.get("storedHiddenBoolean").then((val) => {
      this.hidden = val;
    })
  }

  // access country and player data from their providers 
  // set and get storage variables related to country and player data
  ionViewWillEnter() {
    this.storage.get("storedMinAge").then((val) => {
      this.minAge = val;
    })

    this.storage.get("storedMaxAge").then((val) => {
      this.maxAge = val;
    })

    this.storage.get("storedEnteredNumber").then((val) => {
      this.countryID = val;
    })

    this.storage.get("storedCountryKey").then((val) => {
      this.countryKey = val;
      this.sdp.getPlayerData(this.countryID, this.maxAge, this.minAge).subscribe(data => {
        this.playerData = data.data;
      });

      this.sdp.getCountryData().subscribe(data => {
        this.countryData = data.data;
        try{
          this.countryName = this.countryData[this.countryKey].name;
        } catch (e) {
          this.countryName = "";
          this.storage.set("storedHiddenBoolean", true);
          this.storage.get("storedHiddenBoolean").then((val) => {
            this.hidden = val;
          })
        }
        try {
          this.countryFlagCode = this.countryData[this.countryKey].country_code;
          this.uppercaseCountryFlagCode = this.countryFlagCode.toUpperCase();
        } catch (e) {
          this.storage.set("storedHiddenBoolean", true);
          this.storage.get("storedHiddenBoolean").then((val) => {
            this.hidden = val;
          })
        }
      });
    })
  }

  // get and assign hidden storage variable
  ionViewDidLeave() {
    this.storage.get("storedHiddenBoolean").then((val) => {
      this.hidden = val;
    })
  }

  // push Settings page to the top of the stack
  goToSettingsPage() {
    this.navCtrl.push(SettingsPage);
  }

}
