package com.example.ranet.Models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Product {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("id_manufacturer")
    @Expose
    private String idManufacturer;
    @SerializedName("id_supplier")
    @Expose
    private String idSupplier;
    @SerializedName("id_category_default")
    @Expose
    private String idCategoryDefault;
    @SerializedName("new")
    @Expose
    private Object _new;
    @SerializedName("cache_default_attribute")
    @Expose
    private String cacheDefaultAttribute;
    @SerializedName("id_default_image")
    @Expose
    private String idDefaultImage;
    @SerializedName("id_default_combination")
    @Expose
    private String idDefaultCombination;
    @SerializedName("id_tax_rules_group")
    @Expose
    private String idTaxRulesGroup;
    @SerializedName("position_in_category")
    @Expose
    private String positionInCategory;
    @SerializedName("manufacturer_name")
    @Expose
    private String manufacturerName;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id_shop_default")
    @Expose
    private String idShopDefault;
    @SerializedName("reference")
    @Expose
    private String reference;
    @SerializedName("supplier_reference")
    @Expose
    private String supplierReference;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("depth")
    @Expose
    private String depth;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("quantity_discount")
    @Expose
    private String quantityDiscount;
    @SerializedName("ean13")
    @Expose
    private String ean13;
    @SerializedName("isbn")
    @Expose
    private String isbn;
    @SerializedName("upc")
    @Expose
    private String upc;
    @SerializedName("cache_is_pack")
    @Expose
    private String cacheIsPack;
    @SerializedName("cache_has_attachments")
    @Expose
    private String cacheHasAttachments;
    @SerializedName("is_virtual")
    @Expose
    private String isVirtual;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("additional_delivery_times")
    @Expose
    private String additionalDeliveryTimes;
/*    @SerializedName("delivery_in_stock")
    @Expose
    private List<DeliveryInStock> deliveryInStock = null;
    @SerializedName("delivery_out_stock")
    @Expose
    private List<DeliveryOutStock> deliveryOutStock = null;*/
    @SerializedName("on_sale")
    @Expose
    private String onSale;
    @SerializedName("online_only")
    @Expose
    private String onlineOnly;
    @SerializedName("ecotax")
    @Expose
    private String ecotax;
    @SerializedName("minimal_quantity")
    @Expose
    private String minimalQuantity;
    @SerializedName("low_stock_threshold")
    @Expose
    private Object lowStockThreshold;
    @SerializedName("low_stock_alert")
    @Expose
    private String lowStockAlert;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("wholesale_price")
    @Expose
    private String wholesalePrice;
    @SerializedName("unity")
    @Expose
    private String unity;
    @SerializedName("unit_price_ratio")
    @Expose
    private String unitPriceRatio;
    @SerializedName("additional_shipping_cost")
    @Expose
    private String additionalShippingCost;
    @SerializedName("customizable")
    @Expose
    private String customizable;
    @SerializedName("text_fields")
    @Expose
    private String textFields;
    @SerializedName("uploadable_files")
    @Expose
    private String uploadableFiles;
    @SerializedName("active")
    @Expose
    private String active;
    @SerializedName("redirect_type")
    @Expose
    private String redirectType;
    @SerializedName("id_type_redirected")
    @Expose
    private String idTypeRedirected;
    @SerializedName("available_for_order")
    @Expose
    private String availableForOrder;
    @SerializedName("available_date")
    @Expose
    private String availableDate;
    @SerializedName("show_condition")
    @Expose
    private String showCondition;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("show_price")
    @Expose
    private String showPrice;
    @SerializedName("indexed")
    @Expose
    private String indexed;
    @SerializedName("visibility")
    @Expose
    private String visibility;
    @SerializedName("advanced_stock_management")
    @Expose
    private String advancedStockManagement;
    @SerializedName("date_add")
    @Expose
    private String dateAdd;
    @SerializedName("date_upd")
    @Expose
    private String dateUpd;
    @SerializedName("pack_stock_type")
    @Expose
    private String packStockType;
/*    @SerializedName("meta_description")
    @Expose
    private List<MetaDescription> metaDescription = null;
    @SerializedName("meta_keywords")
    @Expose
    private List<MetaKeyword> metaKeywords = null;
    @SerializedName("meta_title")
    @Expose
    private List<MetaTitle> metaTitle = null;
    @SerializedName("link_rewrite")
    @Expose
    private List<LinkRewrite> linkRewrite = null;
    @SerializedName("name")
    @Expose
    private List<Name> name = null;
    @SerializedName("description")
    @Expose
    private List<Description> description = null;
    @SerializedName("description_short")
    @Expose
    private List<DescriptionShort> descriptionShort = null;
    @SerializedName("available_now")
    @Expose
    private List<AvailableNow> availableNow = null;
    @SerializedName("available_later")
    @Expose
    private List<AvailableLater> availableLater = null;*/
    @SerializedName("associations")
    @Expose
    private Associations associations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(String idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public String getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(String idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getIdCategoryDefault() {
        return idCategoryDefault;
    }

    public void setIdCategoryDefault(String idCategoryDefault) {
        this.idCategoryDefault = idCategoryDefault;
    }

    public Object getNew() {
        return _new;
    }

    public void setNew(Object _new) {
        this._new = _new;
    }

    public String getCacheDefaultAttribute() {
        return cacheDefaultAttribute;
    }

    public void setCacheDefaultAttribute(String cacheDefaultAttribute) {
        this.cacheDefaultAttribute = cacheDefaultAttribute;
    }

    public String getIdDefaultImage() {
        return idDefaultImage;
    }

    public void setIdDefaultImage(String idDefaultImage) {
        this.idDefaultImage = idDefaultImage;
    }

    public String getIdDefaultCombination() {
        return idDefaultCombination;
    }

    public void setIdDefaultCombination(String idDefaultCombination) {
        this.idDefaultCombination = idDefaultCombination;
    }

    public String getIdTaxRulesGroup() {
        return idTaxRulesGroup;
    }

    public void setIdTaxRulesGroup(String idTaxRulesGroup) {
        this.idTaxRulesGroup = idTaxRulesGroup;
    }

    public String getPositionInCategory() {
        return positionInCategory;
    }

    public void setPositionInCategory(String positionInCategory) {
        this.positionInCategory = positionInCategory;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdShopDefault() {
        return idShopDefault;
    }

    public void setIdShopDefault(String idShopDefault) {
        this.idShopDefault = idShopDefault;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSupplierReference() {
        return supplierReference;
    }

    public void setSupplierReference(String supplierReference) {
        this.supplierReference = supplierReference;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getQuantityDiscount() {
        return quantityDiscount;
    }

    public void setQuantityDiscount(String quantityDiscount) {
        this.quantityDiscount = quantityDiscount;
    }

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getCacheIsPack() {
        return cacheIsPack;
    }

    public void setCacheIsPack(String cacheIsPack) {
        this.cacheIsPack = cacheIsPack;
    }

    public String getCacheHasAttachments() {
        return cacheHasAttachments;
    }

    public void setCacheHasAttachments(String cacheHasAttachments) {
        this.cacheHasAttachments = cacheHasAttachments;
    }

    public String getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(String isVirtual) {
        this.isVirtual = isVirtual;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAdditionalDeliveryTimes() {
        return additionalDeliveryTimes;
    }

    public void setAdditionalDeliveryTimes(String additionalDeliveryTimes) {
        this.additionalDeliveryTimes = additionalDeliveryTimes;
    }

/*
    public List<DeliveryInStock> getDeliveryInStock() {
        return deliveryInStock;
    }

    public void setDeliveryInStock(List<DeliveryInStock> deliveryInStock) {
        this.deliveryInStock = deliveryInStock;
    }

    public List<DeliveryOutStock> getDeliveryOutStock() {
        return deliveryOutStock;
    }

    public void setDeliveryOutStock(List<DeliveryOutStock> deliveryOutStock) {
        this.deliveryOutStock = deliveryOutStock;
    }
*/

    public String getOnSale() {
        return onSale;
    }

    public void setOnSale(String onSale) {
        this.onSale = onSale;
    }

    public String getOnlineOnly() {
        return onlineOnly;
    }

    public void setOnlineOnly(String onlineOnly) {
        this.onlineOnly = onlineOnly;
    }

    public String getEcotax() {
        return ecotax;
    }

    public void setEcotax(String ecotax) {
        this.ecotax = ecotax;
    }

    public String getMinimalQuantity() {
        return minimalQuantity;
    }

    public void setMinimalQuantity(String minimalQuantity) {
        this.minimalQuantity = minimalQuantity;
    }

    public Object getLowStockThreshold() {
        return lowStockThreshold;
    }

    public void setLowStockThreshold(Object lowStockThreshold) {
        this.lowStockThreshold = lowStockThreshold;
    }

    public String getLowStockAlert() {
        return lowStockAlert;
    }

    public void setLowStockAlert(String lowStockAlert) {
        this.lowStockAlert = lowStockAlert;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(String wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public String getUnitPriceRatio() {
        return unitPriceRatio;
    }

    public void setUnitPriceRatio(String unitPriceRatio) {
        this.unitPriceRatio = unitPriceRatio;
    }

    public String getAdditionalShippingCost() {
        return additionalShippingCost;
    }

    public void setAdditionalShippingCost(String additionalShippingCost) {
        this.additionalShippingCost = additionalShippingCost;
    }

    public String getCustomizable() {
        return customizable;
    }

    public void setCustomizable(String customizable) {
        this.customizable = customizable;
    }

    public String getTextFields() {
        return textFields;
    }

    public void setTextFields(String textFields) {
        this.textFields = textFields;
    }

    public String getUploadableFiles() {
        return uploadableFiles;
    }

    public void setUploadableFiles(String uploadableFiles) {
        this.uploadableFiles = uploadableFiles;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRedirectType() {
        return redirectType;
    }

    public void setRedirectType(String redirectType) {
        this.redirectType = redirectType;
    }

    public String getIdTypeRedirected() {
        return idTypeRedirected;
    }

    public void setIdTypeRedirected(String idTypeRedirected) {
        this.idTypeRedirected = idTypeRedirected;
    }

    public String getAvailableForOrder() {
        return availableForOrder;
    }

    public void setAvailableForOrder(String availableForOrder) {
        this.availableForOrder = availableForOrder;
    }

    public String getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(String availableDate) {
        this.availableDate = availableDate;
    }

    public String getShowCondition() {
        return showCondition;
    }

    public void setShowCondition(String showCondition) {
        this.showCondition = showCondition;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(String showPrice) {
        this.showPrice = showPrice;
    }

    public String getIndexed() {
        return indexed;
    }

    public void setIndexed(String indexed) {
        this.indexed = indexed;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getAdvancedStockManagement() {
        return advancedStockManagement;
    }

    public void setAdvancedStockManagement(String advancedStockManagement) {
        this.advancedStockManagement = advancedStockManagement;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    public String getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(String dateUpd) {
        this.dateUpd = dateUpd;
    }

    public String getPackStockType() {
        return packStockType;
    }

    public void setPackStockType(String packStockType) {
        this.packStockType = packStockType;
    }

/*    public List<MetaDescription> getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(List<MetaDescription> metaDescription) {
        this.metaDescription = metaDescription;
    }

    public List<MetaKeyword> getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(List<MetaKeyword> metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public List<MetaTitle> getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(List<MetaTitle> metaTitle) {
        this.metaTitle = metaTitle;
    }

    public List<LinkRewrite> getLinkRewrite() {
        return linkRewrite;
    }

    public void setLinkRewrite(List<LinkRewrite> linkRewrite) {
        this.linkRewrite = linkRewrite;
    }

    public List<Name> getName() {
        return name;
    }

    public void setName(List<Name> name) {
        this.name = name;
    }

    public List<Description> getDescription() {
        return description;
    }

    public void setDescription(List<Description> description) {
        this.description = description;
    }

    public List<DescriptionShort> getDescriptionShort() {
        return descriptionShort;
    }

    public void setDescriptionShort(List<DescriptionShort> descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    public List<AvailableNow> getAvailableNow() {
        return availableNow;
    }

    public void setAvailableNow(List<AvailableNow> availableNow) {
        this.availableNow = availableNow;
    }

    public List<AvailableLater> getAvailableLater() {
        return availableLater;
    }

    public void setAvailableLater(List<AvailableLater> availableLater) {
        this.availableLater = availableLater;
    }*/

    public Associations getAssociations() {
        return associations;
    }

    public void setAssociations(Associations associations) {
        this.associations = associations;
    }

}