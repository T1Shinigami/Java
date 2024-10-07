//Autor: Samperio Ávalos José Ángel
//Funcion: Trabaja con archivos
//			Realiza corrimiento a la izquierda y derecha
//			Realiza una busqueda secuencial
//			Contiene una funcion sobreescritura, al usarla desde el menu se puede guardar en el ultimo archivo leido lo que haya en el arreglo

#include<iostream>
#include<stdio.h>
#include<stdlib.h>
#include<string>
#include<fstream>
#include<time.h>
#include<locale.h>
using namespace std;


//Variales globales CON IDENTACION
	int repeticion=0;
	int opcion=0; //controla la ejecucion del menu
	int i=0, j=0;
	int n=0;
	int cn=0;
	int guardacn=0;
	int arreglo[1000];
	int numeroBuscar=0;
	int seEncontro=0;
	int aux=0;
	string archivoSeleccionado;
	string nombreArchivoE;     //nombre del archivo de entrada
	string nombreArchivoS;     //nombre del archivo de salida


//Declaracion de la estructura que permite leer datos del archivo de entrada y copiarlos a un arreglo
struct Entrada {           
	int valor;
} entrada;

//Declaracion de la estructura que permite copiar los datos del arreglo y guardarlos en un archivo de salida
struct Salida {          
	int valor;
} salida;


//Prototipos
	int menu();
	int impresion();
	int capturaDatos();
	int leerArchivo();
	int corrimientoIzq();
	int corrimientoDer();
	int ordenamientoBurbuja();
	int ordenamientoFlotacion();
	int busquedaSec();
	int guardarArchivo();
	int calculo();
	int sobreEscribir();
	

//Funcion impresion, imprime todos los datos del archivo
int impresion(){
	//leerArchivo();
	printf("\nDatos guardados en el arreglo: ");
	for(i=0;i<n;i++){
		printf("%i ", arreglo[i]); //NO PONER SALTOS DE LINEA AL MOSTRAR O INGRESAR ARREGLOS
	}
	return(0);	
}
	

//Captura de datos	
int capturaDatos(){
	printf("\nTeclee 5 datos separados por espacio\n");
	//Para el for una "i" se llama variable de control, para un while se llama centinela
	for(i=0;i<5;i++){
		scanf("%i", &arreglo[i]);
	}
	return(0);
}


// lectura del archivo 
//  lee los numeros contenidos en el archivo y los copia en el arreglo "arreglo" 
//  Se dejan los numeros en un arreglo llamado "arreglo" para que las funciones puedan trabajar con ellos
int leerArchivo(){
	FILE *archivo1;                                     //Crea un apuntador de archivo, utilizando en la función fopen, el apuntador se le asigná el llamado al archivo
    cout<<"\nTeclea el nombre del archivo de entrada (sin espacio, ni caracteres especiales):   ";
	cin>>nombreArchivoE;
	nombreArchivoE+= ".txt";						 	// Se le agrega al nombre del archivo la extension ".txt" 
	archivo1 = fopen(nombreArchivoE.c_str(), "r");      // Se abre el archivo de modo lectura  
	if(archivo1== NULL ){                       
	    cout<<"\nNo se puede abrir el archivo "; 
	    exit (1);
	}                                   
	else{
	  	cout<<"\nSe abrio correctamente el archivo "<<nombreArchivoE.c_str();
    }
    	
    //Lee los datos del archivo y copia los numeros contenidos en el archivo en el arreglo "arreglo"   	
    cn=0;
    for (int i=0; !feof(archivo1); i++) {            // Repite hasta que sea el fin del archivo
        fscanf (archivo1, "%i", &entrada.valor);     // Lee el numero contenido en el archivo y lo guarda en la estructura
        arreglo[i]=entrada.valor;                    // El numero contenido en la estructura lo pasa al arreglo "arreglo"
        cn++;                                        // suma 1 al contador de numeros leidos
	}
	cn--;
	cout<<"\n\nSe ha generado el arreglo con los datos del archivo de entrada";	
	cout<<"\nLa cantidad de numeros contenidos en el arreglo son:  "<<cn<<"\n\n";
	n=cn;
	fclose(archivo1);                             //cierra el archivo de entrada
	archivoSeleccionado=nombreArchivoE; //guardado para la funcion de sobreescritura
	
	return(0);
}
	

//mueve todos los elementos del arreglo a la izquierda
int corrimientoIzq(){
	printf("Datos antes del corrimiento a la izquierda: ");
	impresion();
	aux=arreglo[0];
	for(i=0;i<n-1;i++){
		arreglo[i]=arreglo[i+1];
	}
	arreglo[n-1]=aux;
	
	printf("Datos despues del corrimiento a la izquierda: ");
	impresion();
	
	return(0);
}


//mueve todos los elementos del arreglo a la derecha
int corrimientoDer(){
	printf("Datos antes del corrimiento a la derecha: ");
	impresion();
	aux=arreglo[n-1];
	for(i=0;i<n-1;i++){
		arreglo[n-1]=arreglo[n-2-i];
	}
	arreglo[0]=aux;
	
	printf("Datos despues del corrimiento a la derecha: ");
	impresion();
	return(0);
}


//Busqueda secuencial
int busquedaSec(){
	impresion();
	seEncontro=0;
	printf("\nTeclee el numero a buscar dentro del arreglo: ");
	scanf("%i", &numeroBuscar);
	for(i=0; i<n; i++){
		if(numeroBuscar == arreglo[i]){
			printf("\nEl numero %i se encuentra en la posicion %i", numeroBuscar, i+1);
			seEncontro=1;
		}
	}
	if(seEncontro==0){
		printf("El numero %i no esta dentro del arreglo", numeroBuscar);
	}
	return(0);
}


//Funcion de guardado de archivos, genera un archivo y despues lee cada dato del archivo para guardarlo en el arreglo
int guardarArchivo(){
	FILE *archivo2;                                         //Crea un apuntador de archivo, utilizando en la función fopen, el apuntador se le asigná el llamado al archivo
    cout<<"\n\n Teclea el nombre del archivo de salida (sin espacios, ni caracteres especiales):   ";
	cin>>nombreArchivoS;
	nombreArchivoS+= ".txt";						 		// se agrega la extension ".txt"
	archivo2 = fopen(nombreArchivoS.c_str(), "w");		    // se abre el archivo de modo escritura 
	if(archivo2== NULL ){
		cout<<"\nNo se puede abrir el archivo ";
		exit(1);
    }
	else{
		cout<<"\nSe abrio el archivo  "<<nombreArchivoS.c_str()<<"  correctamente\n";
    }

    cout<<"\n\nGuarda los numeros contenidos en el arreglo en el archivo";
    guardacn=0;
    for (i=0; i<n; i++) {
        salida.valor=arreglo[i];
        fprintf(archivo2, "%i\n", salida.valor);
        guardacn++;
    }
    
    cout<<"\n\nTotal de numeros guardados en el segundo archivo son: "<<guardacn;
    cout<<"\n\n";
	fclose(archivo2);
	return(0);
}


//Funcion de ordenamiento por metodo de burbuja
int ordenamientoBurbuja(){
	printf("Datos antes del ordenamiento por burbuja: ");
	impresion();
	for(j=0;j<n-1;j++){
		for(i=j;i<n-1;i++){
			if(arreglo[i+1]<arreglo[j]){
				aux=arreglo[j];
				arreglo[j]=arreglo[i+1];
				arreglo[i+1]=aux;
			}
		}
	}
	printf("Datos despues del ordenamiento por burbuja: ");
	impresion();
	return(0);
}


//Funcion de prdenamiento por metodo de flotacion
int ordenamientoFlotacion(){
	printf("Datos antes del ordenamiento por flotacion: ");
	impresion();
	for(i=0;i<n-1;i++){
		for(j=0;j<n-1;j++){
			if(arreglo[j]>arreglo[j+1]){
				aux=arreglo[j];
				arreglo[j]=arreglo[j+1];
				arreglo[j+1]=aux;
			}
		}
	}
	
	printf("Datos despues del ordenamiento por flotacion: ");
	impresion();
	return(0);
}


//Funcion calculo
int calculo(){
	printf("Datos antes del calculo: ");
	impresion();
	for(i=0;i<n;i++){
		arreglo[i]=arreglo[i]*1.16;
	}
	
	printf("Datos despues del ordenamiento por flotacion: ");
	impresion();
	
	return(0);
}


//Funcion sobrEescribir: es una funcion que guarda lo que hay actualmente en el arreglo en el ultimo archivo leido
int sobreEscribir(){
	FILE *archivo3;
	archivo3 = fopen(archivoSeleccionado.c_str(), "w");		    // se abre el archivo de modo escritura 
	if(archivo3== NULL ){
		cout<<"\nNo se puede abrir el archivo ";
		exit(1);
    }
	else{
		cout<<"\nSe abrio el archivo  "<<nombreArchivoS.c_str()<<"  correctamente\n";
    }

    cout<<"\n\nGuarda los numeros contenidos en el arreglo en el archivo";
    guardacn=0;
    for (i=0; i<n; i++) {
        salida.valor=arreglo[i];
        fprintf(archivo3, "%i\n", salida.valor);
        guardacn++;
    }
    
    cout<<"\n\nTotal de numeros guardados en el archivo sobreescrito son: "<<guardacn;
    cout<<"\n\n";
	fclose(archivo3);
	return(0);
}


//Funcion main	
int main(){
	for(repeticion = 0; repeticion == 0;){
		menu();
		switch(opcion){
			case(0):
				printf("\nImpresion contenido del arreglo");
				impresion();
				break;
			case(1):
				cout<<"\nLectura de archivo";
				leerArchivo();
				//printf("\nCaptura de datos");
				//capturaDatos();
				break;
			case(2):
				printf("\nCorrimiento a la izquierda");
				corrimientoIzq();
				break;
			case(3):
				printf("\nCorrimiento a la derecha");
				corrimientoDer();
				break;
			case(4):
				printf("\nBusqueda secuencial");
				busquedaSec();
				break;
			case(5):
				printf("\nGuardar archivo");
				guardarArchivo();
				break;
			case(6):
				printf("\nOrdenamiento por metodo de Burbuja");
				ordenamientoBurbuja();
				break;
			case(7):
				printf("\nOrdenamiento por medio de Flotacion");
				ordenamientoFlotacion();
				break;
			case(8):
				printf("\nCalculo");
				//calculo();
				break;
			case(9):
				printf("\nFuncion sobreescritura");
				sobreEscribir();
				break;
			case(10):
				printf("\nFinaliza el programa");
				repeticion++;
				break;
			default:
				printf("\nOpcion invalida");
		}
		printf("\n");
		system("pause");
	}
}


int menu(){
	system("cls");
	printf("\n\t\tMenu");
	printf("\n0 - Imprimir arreglo");
//	printf("\n1 - Captura de datos en el arreglo");
	printf("\n1 - Leer archivo");
	printf("\n2 - Corrimiento a la izquierda");
	printf("\n3 - Corrimiento a la derecha");
	printf("\n4 - Busqueda secuencial");
	printf("\n5 - Guardar archivo");
	printf("\n6 - Ordenamiento por metodo de Burbuja");
	printf("\n7 - Ordenamiento por medio de Flotacion");
	printf("\n8 - Calculo");
	printf("\n9 - Sobreescritura");
	printf("\n10 - Finalizar programa");
	printf("\nTeclee la opcion deseada: ");
	scanf("%i", &opcion);
	return(0);
}