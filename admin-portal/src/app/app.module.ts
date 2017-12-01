import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserAnimationsModule, NoopAnimationsModule} from '@angular/platform-browser/animations';
import 'hammerjs';
import {
  MatButtonModule,
  MatToolbarModule,
  MatGridListModule,
  MatInputModule
} from "@angular/material";
import { routing } from './app.routing';

import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { LoginComponent } from './components/login/login.component';

import { LoginService } from './services/login.service';

const MAT_MODULES  = [
  MatButtonModule,
  MatToolbarModule,
  MatGridListModule,
  MatInputModule
];

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    routing,
    MAT_MODULES
  ],
  providers: [
    LoginService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
