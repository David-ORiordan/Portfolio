import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { SoccerDataProvider } from '../../providers/soccer-data/soccer-data';

/**
 * Generated class for the CountryListPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-country-list',
  templateUrl: 'country-list.html',
})
export class CountryListPage {
  
  // variables for country data
  countryData: any[];
  keys: any[]

  constructor(public navCtrl: NavController, public navParams: NavParams, private sdp:SoccerDataProvider) {
  }

  // access country data from the provider
  ionViewDidLoad() {
    console.log('ionViewDidLoad CountryListPage');
    this.sdp.getCountryData().subscribe(data => {
      this.countryData = data.data;
      this.keys = Object.keys(this.countryData);
    });
  }

}
