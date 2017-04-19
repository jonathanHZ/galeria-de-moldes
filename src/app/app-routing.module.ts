import { Routes, RouterModule } from '@angular/router';

import { MoldesListComponent } from './moldes-list/moldes-list.component';
import { MoldesDetailComponent } from './moldes-detail/moldes-detail.component';
import { NgModule } from '@angular/core';

const appRoutes: Routes = [
  { path: '', component: MoldesListComponent },
  { path: 'detail', component: MoldesDetailComponent },
  { path: '**', component: MoldesListComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {}
