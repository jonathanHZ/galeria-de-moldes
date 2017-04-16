import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MoldeCardComponent } from './molde-card.component';

describe('MoldeCardComponent', () => {
  let component: MoldeCardComponent;
  let fixture: ComponentFixture<MoldeCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MoldeCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MoldeCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
