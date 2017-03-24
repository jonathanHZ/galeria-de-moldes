import { GaleriaDeMoldesPage } from './app.po';

describe('galeria-de-moldes App', () => {
  let page: GaleriaDeMoldesPage;

  beforeEach(() => {
    page = new GaleriaDeMoldesPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
