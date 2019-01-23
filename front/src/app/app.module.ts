import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms'; // <-- NgModel lives
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SongComponent } from './components/song/song.component';
import { CreateSongComponent } from './components/create-song/create-song.component';
import { ShowSongComponent } from './components/show-song/show-song.component';

import { SongIdService } from './services/song-id.service';
import { SongService } from './services/song.service';

@NgModule({
  declarations: [
    AppComponent,
    SongComponent,
    ShowSongComponent,
    CreateSongComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [SongIdService, SongService],
  bootstrap: [AppComponent]
})
export class AppModule { }
