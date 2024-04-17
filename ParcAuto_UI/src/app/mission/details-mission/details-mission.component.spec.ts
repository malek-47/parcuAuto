import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsMissionComponent } from './details-mission.component';

describe('DetailsMissionComponent', () => {
  let component: DetailsMissionComponent;
  let fixture: ComponentFixture<DetailsMissionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DetailsMissionComponent]
    });
    fixture = TestBed.createComponent(DetailsMissionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
