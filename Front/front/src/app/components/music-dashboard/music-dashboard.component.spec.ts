import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MusicDashboardComponent } from './music-dashboard.component';

describe('MusicDashboardComponent', () => {
  let component: MusicDashboardComponent;
  let fixture: ComponentFixture<MusicDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MusicDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MusicDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
