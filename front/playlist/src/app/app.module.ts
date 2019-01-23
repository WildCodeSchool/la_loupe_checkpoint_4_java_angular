import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http"
import { FormsModule } from "@angular/forms";

import { AppComponent } from './app.component';
import { FormAddSongComponent } from './form-add-song/form-add-song.component';
import { SongListComponent } from './song-list/song-list.component';
import { ModifOrDeleteComponent } from './modif-or-delete/modif-or-delete.component';

@NgModule({
  declarations: [
    AppComponent,
    FormAddSongComponent,
    SongListComponent,
    ModifOrDeleteComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
