import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { SongComponent } from './song/song.component';
import { SongService } from './song.service';

@NgModule({
  declarations: [
    AppComponent,
    SongComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    HttpClientModule
  ],
  providers: [SongService],
  bootstrap: [AppComponent]
})
export class AppModule { }
