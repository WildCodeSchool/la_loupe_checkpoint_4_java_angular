
import { Routes} from '@angular/router';

import { AddPlaylistComponent } from '../component/add-playlist/add-playlist.component';
import { EditPlaylistComponent } from '../component/edit-playlist/edit-playlist.component';
import { PlaylistComponent } from '../playlist/playlist.component';



export const ROUTES: Routes = [
  { path: 'add-playlist', component: AddPlaylistComponent },
  { path: 'edit-playlist', component: EditPlaylistComponent },
  { path: 'list-playlist', component: PlaylistComponent },
  { path: '', pathMatch: 'full', redirectTo: 'list-playlist' },
  { path: '**', pathMatch: 'full', redirectTo: 'list-playlist' }
];

