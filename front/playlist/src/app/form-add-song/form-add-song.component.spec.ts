import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAddSongComponent } from './form-add-song.component';

describe('FormAddSongComponent', () => {
  let component: FormAddSongComponent;
  let fixture: ComponentFixture<FormAddSongComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormAddSongComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormAddSongComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
