import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifOrDeleteComponent } from './modif-or-delete.component';

describe('ModifOrDeleteComponent', () => {
  let component: ModifOrDeleteComponent;
  let fixture: ComponentFixture<ModifOrDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModifOrDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifOrDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
