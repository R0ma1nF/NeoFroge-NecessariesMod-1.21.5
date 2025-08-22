package net.kingusratus.necessariesmod.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ModModels {

    /***************************************************************************************
     * CALLED FUNCTION
     ***************************************************************************************/
    public static void createCakeModels(Block block, Item item, BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        // Generate the full cake model (bites=0)
        ResourceLocation cakeModelLocation = ModelLocationUtils.getModelLocation(block);
        blockModels.modelOutput.accept(cakeModelLocation, ModModels::createFullCakeModel);

        // Generate each slice model (bites=1 to 6)
        for (int bite = 1; bite <= 6; bite++) {
            final int biteCount = bite;
            ResourceLocation sliceModelLocation = ModelLocationUtils.getModelLocation(block, "_slice" + bite);
            blockModels.modelOutput.accept(sliceModelLocation, () -> createCakeSliceModel(biteCount));
        }

        // Generate blockstate with all bite variants
        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(block)
                        .with(PropertyDispatch.initial(BlockStateProperties.BITES)
                                .select(0, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block)))
                                .select(1, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_slice1")))
                                .select(2, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_slice2")))
                                .select(3, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_slice3")))
                                .select(4, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_slice4")))
                                .select(5, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_slice5")))
                                .select(6, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_slice6")))
                        )
        );

        itemModels.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
    }


    /***************************************************************************************
     * HELPER FUNCTIONS
     ***************************************************************************************/

    private static JsonElement createFullCakeModel() {
        JsonObject model = new JsonObject();

        // Add textures
        JsonObject textures = new JsonObject();
        textures.addProperty("particle", "necessariesmod:block/endcake_side");
        textures.addProperty("bottom", "necessariesmod:block/endcake_bottom");
        textures.addProperty("top", "necessariesmod:block/endcake_top");
        textures.addProperty("side", "necessariesmod:block/endcake_side");
        model.add("textures", textures);

        // Add elements
        JsonArray elements = new JsonArray();
        JsonObject element = new JsonObject();

        // From and to coordinates for full cake
        JsonArray from = new JsonArray();
        from.add(1);
        from.add(0);
        from.add(1);
        element.add("from", from);

        JsonArray to = new JsonArray();
        to.add(15);
        to.add(8);
        to.add(15);
        element.add("to", to);

        // Faces for full cake
        JsonObject faces = new JsonObject();

        JsonObject downFace = new JsonObject();
        downFace.addProperty("texture", "#bottom");
        downFace.addProperty("cullface", "down");
        faces.add("down", downFace);

        JsonObject upFace = new JsonObject();
        upFace.addProperty("texture", "#top");
        faces.add("up", upFace);

        JsonObject northFace = new JsonObject();
        northFace.addProperty("texture", "#side");
        faces.add("north", northFace);

        JsonObject southFace = new JsonObject();
        southFace.addProperty("texture", "#side");
        faces.add("south", southFace);

        JsonObject westFace = new JsonObject();
        westFace.addProperty("texture", "#side");
        faces.add("west", westFace);

        JsonObject eastFace = new JsonObject();
        eastFace.addProperty("texture", "#side");
        faces.add("east", eastFace);

        element.add("faces", faces);
        elements.add(element);
        model.add("elements", elements);

        return model;
    }

    private static JsonElement createCakeSliceModel(int biteCount) {
        JsonObject model = new JsonObject();

        // Add textures
        JsonObject textures = new JsonObject();
        textures.addProperty("particle", "necessariesmod:block/endcake_side");
        textures.addProperty("bottom", "necessariesmod:block/endcake_bottom");
        textures.addProperty("top", "necessariesmod:block/endcake_top");
        textures.addProperty("side", "necessariesmod:block/endcake_side");
        textures.addProperty("inside", "necessariesmod:block/endcake_inner");
        model.add("textures", textures);

        // Add elements
        JsonArray elements = new JsonArray();
        JsonObject element = new JsonObject();

        // Calculate fromX based on bite count (matches your existing models)
        int fromX = 1 + (biteCount * 2);

        // From and to coordinates
        JsonArray from = new JsonArray();
        from.add(fromX);
        from.add(0);
        from.add(1);
        element.add("from", from);

        JsonArray to = new JsonArray();
        to.add(15);
        to.add(8);
        to.add(15);
        element.add("to", to);

        // Faces
        JsonObject faces = new JsonObject();

        JsonObject downFace = new JsonObject();
        downFace.addProperty("texture", "#bottom");
        downFace.addProperty("cullface", "down");
        faces.add("down", downFace);

        JsonObject upFace = new JsonObject();
        upFace.addProperty("texture", "#top");
        faces.add("up", upFace);

        JsonObject northFace = new JsonObject();
        northFace.addProperty("texture", "#side");
        faces.add("north", northFace);

        JsonObject southFace = new JsonObject();
        southFace.addProperty("texture", "#side");
        faces.add("south", southFace);

        JsonObject westFace = new JsonObject();
        westFace.addProperty("texture", "#inside");
        faces.add("west", westFace);

        JsonObject eastFace = new JsonObject();
        eastFace.addProperty("texture", "#side");
        faces.add("east", eastFace);

        element.add("faces", faces);
        elements.add(element);
        model.add("elements", elements);

        return model;
    }
}
