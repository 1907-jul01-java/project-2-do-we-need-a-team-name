import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {
  api_key: String = '00481584128e26244bc2e209aa0d0776';
  list_image_size = 'w154';
  page_image_size = 'w342';
  image_url = 'http://image.tmdb.org/t/p/';
  constructor() { }


getListImage(){
  return (this.image_url + this.list_image_size);
}

getPageImage(){
  return (this.image_url + this.page_image_size);
}

getApiKey(){
  return this.api_key;
}
}
