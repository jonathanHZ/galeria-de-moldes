import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'moldeType'
})
export class MoldeTypePipe implements PipeTransform {

  transform(imageType: String): String {

    const types: object = {
      'gdm-m': 'gdmModelado',
      'gdm-p': 'gdmPiao',
      'gdm-l': 'gdmLapidado',
      'gdm-t': 'gdmTruffi',
      'gdm-b': 'gdmBagda',
      'gdm-c': 'gdmCareca'
    };

    return types[imageType.toString()] || 'vacio';
  }

}
