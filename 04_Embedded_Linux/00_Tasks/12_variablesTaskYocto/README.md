# Global Variable Task

## 1. Create a Layer & Recipe

First, create a layer and recipe as described in the previous task. You can find the instructions here:

[Create Layer & Recipe Yocto](https://github.com/Khedr05/ITI_Android_Automotive_Track/tree/main/04_Embedded_Linux/00_Tasks/11_createLayer%26RecipeYocto)

## 2. Modify Your Recipe

Update your recipe with the following code to check the value of the variable:

```bash
SUMMARY = "Sherif recipe"
DESCRIPTION = "Recipe created by Sherif Ashraf Khedr"
LICENSE = "CLOSED"

python do_display_banner() {
    # Print the banner
    bb.plain("***************************************************")
    bb.plain("*                                                 *")
    bb.plain("*  Sherif recipe created by Sherif Ashraf Khedr   *")
    bb.plain("*                                                 *")
    bb.plain("***************************************************")
    
    # Retrieve and check the value of MY_GLOBAL
    my_global = d.getVar('MY_GLOBAL', True)
    
    if my_global == "0":
        bb.plain("\nHello Sherif\n")
    elif my_global == "1":
        bb.plain("\nHi Sherif\n")
    else:
        bb.plain("\nInvalid Value\n")
}

addtask display_banner before do_build
```

For reference, you can view a sample recipe [here](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/12_variablesTaskYocto/img/00_recipe.png).

## 3. Add the Global Variable to `local.conf`

Navigate to your build environment configuration directory and open `local.conf`:

```bash
cd path/yourbuildenviroment/conf
nano local.conf
```

Add the following line to set the global variable:

```bash
MY_GLOBAL=""
```

For reference, see the example `local.conf` [here](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/12_variablesTaskYocto/img/01_localConf.png).

## 4. Compile the Recipe

Compile the recipe using Bitbake:

```bash
bitbake sherifrecipe
```

### Test Cases

- **Invalid Case**: Set the global variable to `"5"` and compile the recipe to check the result.

  ![Invalid Case](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/12_variablesTaskYocto/img/02_localConfSet5.png)
  ![Compile Result](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/12_variablesTaskYocto/img/03_invalidCase.png)

- **Hello Case**: Set the variable to `"0"` and compile the recipe to check the result.

  ![Hello Case](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/12_variablesTaskYocto/img/04_localConfSet0.png)
  ![Compile Result](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/12_variablesTaskYocto/img/05_helloCase.png)

- **Hi Case**: Set the variable to `"1"` and compile the recipe to check the result.

  ![Hi Case](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/12_variablesTaskYocto/img/06_localConfSet1.png)
  ![Compile Result](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/12_variablesTaskYocto/img/07_hiCase.png)

---
