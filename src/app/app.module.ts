import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { HeaderComponent } from './core/header/header.component';
import { FooterComponent } from './core/footer/footer.component';
import { MoldesListComponent } from './moldes-list/moldes-list.component';
import { MoldesDetailComponent } from './moldes-detail/moldes-detail.component';
import { GdmServiceService } from './shared/api/gdm-service.service';
import { MoldeCardComponent } from './shared/components/molde-card/molde-card.component';
import { CapitalizePipe } from './shared/filters/capitalize.pipe';
import { MoldeTypePipe } from './shared/filters/molde-type.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    MoldesListComponent,
    MoldesDetailComponent,
    MoldeCardComponent,
    CapitalizePipe,
    MoldeTypePipe,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [GdmServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
