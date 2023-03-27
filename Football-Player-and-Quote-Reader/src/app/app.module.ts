import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { SettingsPage } from '../pages/settings/settings';
import { HttpClientModule } from '@angular/common/http';
import { IonicStorageModule } from '@ionic/storage';
import { CountryListPage } from '../pages/country-list/country-list';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { RandomQuoteProvider } from '../providers/random-quote/random-quote';
import { SoccerDataProvider } from '../providers/soccer-data/soccer-data';

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    SettingsPage,
    CountryListPage
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    IonicModule.forRoot(MyApp),
    IonicStorageModule.forRoot()
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    SettingsPage,
    CountryListPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    RandomQuoteProvider,
    SoccerDataProvider
  ]
})
export class AppModule {}
