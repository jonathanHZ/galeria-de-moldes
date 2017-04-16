import { Title } from '@angular/platform-browser/platform-browser';
import { Component, OnInit } from '@angular/core';
import { GdmServiceService } from '../shared/api/gdm-service.service';
import { Observable } from 'rxjs/Rx';
import { Molde } from '../shared/domain/molde';

@Component({
  selector: 'app-moldes-list',
  templateUrl: './moldes-list.component.html',
  styleUrls: ['./moldes-list.component.less']
})
export class MoldesListComponent implements OnInit {
  moldes: Observable<Array<Molde>>;
  moldesList: Array<Molde> = [] ;

  constructor(private GdmServiceService: GdmServiceService) { }

  ngOnInit() {
     this.moldes = this.GdmServiceService.getMoldes();

     this.moldes.subscribe( (res: Array<Molde>) => {
       this.moldesList = res;
     });
  }

}
