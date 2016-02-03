# 01_Calculator

Se pide añadir 
 - una fila debajo de los numeros 1 2 3 donde con los botones `.`, `0` y `ans`, en ese orden
 - que funcionen las operaciones de resta, multiplicación y división

Para ello solo es necesario modificar [MainActivity.java](https://github.com/androiddevsteam/01_Calculator/blob/master/app/src/main/java/com/androiddevsteam/calculator/MainActivity.java) y [content_main.xml](https://github.com/androiddevsteam/01_Calculator/blob/master/app/src/main/res/layout/content_main.xml)

# Pasos a seguir

Hacer un fork a tu cuenta (un fork por cada grupo) haciendo click en el botón de fork arriba a la derecha de esta página.
Desde la calculadora de vuestra cuenta, en Ajustes - Colaboradores, añadir a la otra persona del grupo para que pueda hacer cambios en el proyecto.

Descargar el proyecto, abriendo un terminal y escribiendo el siguiente comando:

  `git clone https://github.com/androiddevsteam/01_Calculator`
  
Se abre Android Studio, y desde el menú `File - Open` se selecciona la carpeta del proyecto.

Se editan los archivos mencionados anteriormente para que funcione la calculadora.

# Git

Cada vez que hagáis un cambio en un proyecto o añadáis algo nuevo, deberíais "guardar el progreso" en git. Git se encargará de que podáis volver a cualquier punto del proyecto en cualquier momento.

Cuando hayáis hecho un cambio, desde la carpeta del proyecto:

```
# Decirle a git que queremos guardar todos los archivos
git add --all .
# Guardarlos localmente, con un mensaje indicando que cambios se han hecho
git commit
```

# Subir a GitHub

(Si no has hecho el fork, hazlo ahora)

Cuando esté acabada la calculadora:

**Cambiar "cuenta" por la cuenta de github de la persona que haya hecho el fork en el siguiente comando!**
```
git remote add github https://github.com/cuenta/01_Calculadora.git
git push -u github master
```

Ahora estarán los cambios en tu cuenta de github.
