let boolVar1: boolean = true;
let boolVar2: boolean = false;

console.log(boolVar1);
console.log(boolVar2);

let decimal: number = 5;

console.log(decimal);

let color: string = 'red';
console.log(color);

let firstName: string = 'Dmitry';
console.log(`My name is ${firstName}`);

let firstArray: number[] = [1, 2, 3];
console.log(firstArray);

let secondArray: Array<number> = [4, 5, 6];
console.log(secondArray);

let tuple: [string, number] = ['some text', 123.45];
console.log(tuple);

enum Color {Red = 10, Green, Blue}
let favouriteColor: Color = Color.Green;
console.log(favouriteColor);

let x: any = 13;
console.log(x);
x = 'text';
console.log(x);

let text: any = 'dummy text';
let anotherText: string = 'another ' + (text as string).toUpperCase();
console.log(anotherText);
