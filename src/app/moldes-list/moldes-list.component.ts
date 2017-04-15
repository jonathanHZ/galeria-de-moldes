import { Title } from '@angular/platform-browser/platform-browser';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-moldes-list',
  templateUrl: './moldes-list.component.html',
  styleUrls: ['./moldes-list.component.less']
})
export class MoldesListComponent implements OnInit {
  title: String = '';
  constructor() { }

  ngOnInit() {
    this.title = 'app works!';
  }

}
