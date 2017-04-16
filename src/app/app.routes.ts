import { Routes } from '@angular/router';

import { MoldesListComponent } from './moldes-list/moldes-list.component';
import { MoldesDetailComponent } from './moldes-detail/moldes-detail.component';

export const appRoutes: Routes = [
  { path: '', component: MoldesListComponent },
  { path: 'detail', component: MoldesDetailComponent }
];
