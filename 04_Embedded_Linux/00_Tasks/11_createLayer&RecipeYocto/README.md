# Yocto Create Layer & Recipe

## 1. Generate the Layer Using Bitbake

```bash
bitbake-layers create-layer ../meta-sherif
```

- **Layer Name**: `meta-sherif`
- **Location**: The layer must be in a path outside the `poky` directory.
- **Outcome**: This command will create 3 directories and 4 files based on the template.

![Create Layer](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/11_createLayer%26RecipeYocto/img/00_createLayer.png)

## 2. Show All Layers

```bash
bitbake-layers show-layers
```

![Layers Before Adding](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/11_createLayer%26RecipeYocto/img/01_layersBeforeAdd.png)

## 3. Add the New Layer

```bash
bitbake-layers add-layer ../meta-sherif
```

Alternatively, you can add the layer manually:

```bash
nano /poky/build/conf/bblayers.conf
```

- **Modification**: Find the `BBLAYERS` variable and append the path of the new layer.

![Add Layer Path](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/11_createLayer%26RecipeYocto/img/02_addLayerPath.png)

## 4. Verify the Layer Addition

```bash
bitbake-layers show-layers
```

![Layers After Adding](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/11_createLayer%26RecipeYocto/img/03_layersAfterAdd.png)

## 5. Compile the Example Recipe

```bash
bitbake example
```

![Execute Recipe](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/11_createLayer%26RecipeYocto/img/04_excuteRecipe.png)

## 6. Create a New Recipe

```bash
cd path/meta-sherif/recipes-example
mkdir sherif_recipes
touch sherifrecipe_1.0.bb
nano sherifrecipe_1.0.bb
```

- **Recipe Content**:

```bash
SUMMARY = "Sherif recipe"
DESCRIPTION = "Recipe created by Sherif Ashraf Khedr"
LICENSE = "CLOSED"

python do_display_banner() {
    bb.plain("***************************************************")
    bb.plain("*                                              *")
    bb.plain("*  Sherif recipe created by Sherif Ashraf Khedr   *")
    bb.plain("*                                              *")
    bb.plain("***************************************************")
}
addtask display_banner before do_build
```

![Sherif Recipe](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/11_createLayer%26RecipeYocto/img/05_sherifRecipe.png)

- **To Compile the Recipe**:

```bash
bitbake sherifrecipe
```

![Recipe Compile](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/11_createLayer%26RecipeYocto/img/06_recipeCompile.png)

---
