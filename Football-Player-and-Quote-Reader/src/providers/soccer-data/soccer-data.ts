import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Storage } from '@ionic/storage';

/*
  Generated class for the SoccerDataProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class SoccerDataProvider {

  constructor(public http: HttpClient, private storage: Storage) {
    console.log('Hello SoccerDataProvider Provider');
  }

  getCountryData(): Observable<any> {
    return this.http.get("https://app.sportdataapi.com/api/v1/soccer/countries?apikey=0a98ecc0-7654-11ed-85d1-9372fe0810fc&continent=Europe");
  }

  getPlayerData(countryID, maxAge: number, minAge: number): Observable<any> {
     return this.http.get("https://app.sportdataapi.com/api/v1/soccer/players?apikey=0a98ecc0-7654-11ed-85d1-9372fe0810fc&country_id=" + countryID + "&max_age=" + maxAge + "&min_age=" + minAge);
  }

}
