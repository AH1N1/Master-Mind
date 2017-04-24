package sample;

import com.sun.javafx.css.Style;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.PickRay;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.scene.DirtyBits;
import com.sun.javafx.scene.input.PickResultChooser;
import com.sun.javafx.sg.prism.NGNode;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.WritableValue;
import javafx.collections.ObservableList;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;
import javafx.event.EventDispatchChain;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.Skin;
import javafx.scene.image.WritableImage;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.util.Callback;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Woj on 2017-04-24.
 */
public class OwnLabel extends Label {

    private boolean active;

    public OwnLabel(boolean active){
        this.active =active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public OwnLabel() {
        super();
    }

    public OwnLabel(String text) {
        super(text);
    }

    public OwnLabel(String text, Node graphic) {
        super(text, graphic);
    }

    @Override
    public ObjectProperty<Node> labelForProperty() {
        return super.labelForProperty();
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return super.createDefaultSkin();
    }

    @Override
    protected Boolean impl_cssGetFocusTraversableInitialValue() {
        return super.impl_cssGetFocusTraversableInitialValue();
    }

    @Override
    public Orientation getContentBias() {
        return super.getContentBias();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected Pos impl_cssGetAlignmentInitialValue() {
        return super.impl_cssGetAlignmentInitialValue();
    }

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getControlCssMetaData() {
        return super.getControlCssMetaData();
    }

    @Override
    public boolean isResizable() {
        return super.isResizable();
    }

    @Override
    protected double computeMinWidth(double height) {
        return super.computeMinWidth(height);
    }

    @Override
    protected double computeMinHeight(double width) {
        return super.computeMinHeight(width);
    }

    @Override
    protected double computeMaxWidth(double height) {
        return super.computeMaxWidth(height);
    }

    @Override
    protected double computeMaxHeight(double width) {
        return super.computeMaxHeight(width);
    }

    @Override
    protected double computePrefWidth(double height) {
        return super.computePrefWidth(height);
    }

    @Override
    protected double computePrefHeight(double width) {
        return super.computePrefHeight(width);
    }

    @Override
    public double getBaselineOffset() {
        return super.getBaselineOffset();
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
    }

    @Override
    protected StringProperty skinClassNameProperty() {
        return super.skinClassNameProperty();
    }

    @Override
    protected void impl_processCSS(WritableValue<Boolean> unused) {
        super.impl_processCSS(unused);
    }

    @Override
    public Object queryAccessibleAttribute(AccessibleAttribute attribute, Object... parameters) {
        return super.queryAccessibleAttribute(attribute, parameters);
    }

    @Override
    public void executeAccessibleAction(AccessibleAction action, Object... parameters) {
        super.executeAccessibleAction(action, parameters);
    }

    @Override
    protected void setWidth(double value) {
        super.setWidth(value);
    }

    @Override
    protected void setHeight(double value) {
        super.setHeight(value);
    }

    @Override
    public void setMinSize(double minWidth, double minHeight) {
        super.setMinSize(minWidth, minHeight);
    }

    @Override
    public void setPrefSize(double prefWidth, double prefHeight) {
        super.setPrefSize(prefWidth, prefHeight);
    }

    @Override
    public void setMaxSize(double maxWidth, double maxHeight) {
        super.setMaxSize(maxWidth, maxHeight);
    }

    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
    }

    @Override
    protected double snapSpace(double value) {
        return super.snapSpace(value);
    }

    @Override
    protected double snapSize(double value) {
        return super.snapSize(value);
    }

    @Override
    protected double snapPosition(double value) {
        return super.snapPosition(value);
    }

    @Override
    protected void positionInArea(Node child, double areaX, double areaY, double areaWidth, double areaHeight, double areaBaselineOffset, HPos halignment, VPos valignment) {
        super.positionInArea(child, areaX, areaY, areaWidth, areaHeight, areaBaselineOffset, halignment, valignment);
    }

    @Override
    protected void layoutInArea(Node child, double areaX, double areaY, double areaWidth, double areaHeight, double areaBaselineOffset, HPos halignment, VPos valignment) {
        super.layoutInArea(child, areaX, areaY, areaWidth, areaHeight, areaBaselineOffset, halignment, valignment);
    }

    @Override
    protected void layoutInArea(Node child, double areaX, double areaY, double areaWidth, double areaHeight, double areaBaselineOffset, Insets margin, HPos halignment, VPos valignment) {
        super.layoutInArea(child, areaX, areaY, areaWidth, areaHeight, areaBaselineOffset, margin, halignment, valignment);
    }

    @Override
    protected void layoutInArea(Node child, double areaX, double areaY, double areaWidth, double areaHeight, double areaBaselineOffset, Insets margin, boolean fillWidth, boolean fillHeight, HPos halignment, VPos valignment) {
        super.layoutInArea(child, areaX, areaY, areaWidth, areaHeight, areaBaselineOffset, margin, fillWidth, fillHeight, halignment, valignment);
    }

    @Override
    public void impl_updatePeer() {
        super.impl_updatePeer();
    }

    @Override
    public NGNode impl_createPeer() {
        return super.impl_createPeer();
    }

    @Override
    protected boolean impl_computeContains(double localX, double localY) {
        return super.impl_computeContains(localX, localY);
    }

    @Override
    protected void impl_pickNodeLocal(PickRay pickRay, PickResultChooser result) {
        super.impl_pickNodeLocal(pickRay, result);
    }

    @Override
    public BaseBounds impl_computeGeomBounds(BaseBounds bounds, BaseTransform tx) {
        return super.impl_computeGeomBounds(bounds, tx);
    }

    @Override
    public String getUserAgentStylesheet() {
        return super.getUserAgentStylesheet();
    }

    @Override
    protected ObservableList<Node> getChildren() {
        return super.getChildren();
    }

    @Override
    public ObservableList<Node> getChildrenUnmodifiable() {
        return super.getChildrenUnmodifiable();
    }

    @Override
    protected <E extends Node> List<E> getManagedChildren() {
        return super.getManagedChildren();
    }

    @Override
    public Node lookup(String selector) {
        return super.lookup(selector);
    }

    @Override
    public void requestLayout() {
        super.requestLayout();
    }

    @Override
    public List<String> impl_getAllParentStylesheets() {
        return super.impl_getAllParentStylesheets();
    }

    @Override
    protected void updateBounds() {
        super.updateBounds();
    }

    @Override
    public Object impl_processMXNode(MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
        return super.impl_processMXNode(alg, ctx);
    }

    @Override
    protected void impl_markDirty(DirtyBits dirtyBit) {
        super.impl_markDirty(dirtyBit);
    }

    @Override
    public boolean hasProperties() {
        return super.hasProperties();
    }

    @Override
    public void setUserData(Object value) {
        super.setUserData(value);
    }

    @Override
    public Object getUserData() {
        return super.getUserData();
    }

    @Override
    public Set<Node> lookupAll(String selector) {
        return super.lookupAll(selector);
    }

    @Override
    public void toBack() {
        super.toBack();
    }

    @Override
    public void toFront() {
        super.toFront();
    }

    @Override
    public WritableImage snapshot(SnapshotParameters params, WritableImage image) {
        return super.snapshot(params, image);
    }

    @Override
    public void snapshot(Callback<SnapshotResult, Void> callback, SnapshotParameters params, WritableImage image) {
        super.snapshot(callback, params, image);
    }

    @Override
    public Dragboard startDragAndDrop(TransferMode... transferModes) {
        return super.startDragAndDrop(transferModes);
    }

    @Override
    public void startFullDrag() {
        super.startFullDrag();
    }

    @Override
    public <P extends NGNode> P impl_getPeer() {
        return super.impl_getPeer();
    }

    @Override
    public void relocate(double x, double y) {
        super.relocate(x, y);
    }

    @Override
    public void resizeRelocate(double x, double y, double width, double height) {
        super.resizeRelocate(x, y, width, height);
    }

    @Override
    public double computeAreaInScreen() {
        return super.computeAreaInScreen();
    }

    @Override
    protected void impl_geomChanged() {
        super.impl_geomChanged();
    }

    @Override
    public boolean contains(double localX, double localY) {
        return super.contains(localX, localY);
    }

    @Override
    protected boolean containsBounds(double localX, double localY) {
        return super.containsBounds(localX, localY);
    }

    @Override
    public boolean contains(Point2D localPoint) {
        return super.contains(localPoint);
    }

    @Override
    public boolean intersects(double localX, double localY, double localWidth, double localHeight) {
        return super.intersects(localX, localY, localWidth, localHeight);
    }

    @Override
    public boolean intersects(Bounds localBounds) {
        return super.intersects(localBounds);
    }

    @Override
    public Point2D screenToLocal(double screenX, double screenY) {
        return super.screenToLocal(screenX, screenY);
    }

    @Override
    public Point2D screenToLocal(Point2D screenPoint) {
        return super.screenToLocal(screenPoint);
    }

    @Override
    public Bounds screenToLocal(Bounds screenBounds) {
        return super.screenToLocal(screenBounds);
    }

    @Override
    public Point2D sceneToLocal(double x, double y, boolean rootScene) {
        return super.sceneToLocal(x, y, rootScene);
    }

    @Override
    public Point2D sceneToLocal(Point2D point, boolean rootScene) {
        return super.sceneToLocal(point, rootScene);
    }

    @Override
    public Bounds sceneToLocal(Bounds bounds, boolean rootScene) {
        return super.sceneToLocal(bounds, rootScene);
    }

    @Override
    public Point2D sceneToLocal(double sceneX, double sceneY) {
        return super.sceneToLocal(sceneX, sceneY);
    }

    @Override
    public Point2D sceneToLocal(Point2D scenePoint) {
        return super.sceneToLocal(scenePoint);
    }

    @Override
    public Point3D sceneToLocal(Point3D scenePoint) {
        return super.sceneToLocal(scenePoint);
    }

    @Override
    public Point3D sceneToLocal(double sceneX, double sceneY, double sceneZ) {
        return super.sceneToLocal(sceneX, sceneY, sceneZ);
    }

    @Override
    public Bounds sceneToLocal(Bounds sceneBounds) {
        return super.sceneToLocal(sceneBounds);
    }

    @Override
    public Point2D localToScreen(double localX, double localY) {
        return super.localToScreen(localX, localY);
    }

    @Override
    public Point2D localToScreen(Point2D localPoint) {
        return super.localToScreen(localPoint);
    }

    @Override
    public Point2D localToScreen(double localX, double localY, double localZ) {
        return super.localToScreen(localX, localY, localZ);
    }

    @Override
    public Point2D localToScreen(Point3D localPoint) {
        return super.localToScreen(localPoint);
    }

    @Override
    public Bounds localToScreen(Bounds localBounds) {
        return super.localToScreen(localBounds);
    }

    @Override
    public Point2D localToScene(double localX, double localY) {
        return super.localToScene(localX, localY);
    }

    @Override
    public Point2D localToScene(Point2D localPoint) {
        return super.localToScene(localPoint);
    }

    @Override
    public Point3D localToScene(Point3D localPoint) {
        return super.localToScene(localPoint);
    }

    @Override
    public Point3D localToScene(double x, double y, double z) {
        return super.localToScene(x, y, z);
    }

    @Override
    public Point3D localToScene(Point3D localPoint, boolean rootScene) {
        return super.localToScene(localPoint, rootScene);
    }

    @Override
    public Point3D localToScene(double x, double y, double z, boolean rootScene) {
        return super.localToScene(x, y, z, rootScene);
    }

    @Override
    public Point2D localToScene(Point2D localPoint, boolean rootScene) {
        return super.localToScene(localPoint, rootScene);
    }

    @Override
    public Point2D localToScene(double x, double y, boolean rootScene) {
        return super.localToScene(x, y, rootScene);
    }

    @Override
    public Bounds localToScene(Bounds localBounds, boolean rootScene) {
        return super.localToScene(localBounds, rootScene);
    }

    @Override
    public Bounds localToScene(Bounds localBounds) {
        return super.localToScene(localBounds);
    }

    @Override
    public Point2D parentToLocal(double parentX, double parentY) {
        return super.parentToLocal(parentX, parentY);
    }

    @Override
    public Point2D parentToLocal(Point2D parentPoint) {
        return super.parentToLocal(parentPoint);
    }

    @Override
    public Point3D parentToLocal(Point3D parentPoint) {
        return super.parentToLocal(parentPoint);
    }

    @Override
    public Point3D parentToLocal(double parentX, double parentY, double parentZ) {
        return super.parentToLocal(parentX, parentY, parentZ);
    }

    @Override
    public Bounds parentToLocal(Bounds parentBounds) {
        return super.parentToLocal(parentBounds);
    }

    @Override
    public Point2D localToParent(double localX, double localY) {
        return super.localToParent(localX, localY);
    }

    @Override
    public Point2D localToParent(Point2D localPoint) {
        return super.localToParent(localPoint);
    }

    @Override
    public Point3D localToParent(Point3D localPoint) {
        return super.localToParent(localPoint);
    }

    @Override
    public Point3D localToParent(double x, double y, double z) {
        return super.localToParent(x, y, z);
    }

    @Override
    public Bounds localToParent(Bounds localBounds) {
        return super.localToParent(localBounds);
    }

    @Override
    public void impl_transformsChanged() {
        super.impl_transformsChanged();
    }

    @Override
    protected boolean impl_computeIntersects(PickRay pickRay, PickResultChooser pickResult) {
        return super.impl_computeIntersects(pickRay, pickResult);
    }

    @Override
    public boolean impl_hasTransforms() {
        return super.impl_hasTransforms();
    }

    @Override
    public boolean usesMirroring() {
        return super.usesMirroring();
    }

    @Override
    public void requestFocus() {
        super.requestFocus();
    }

    @Override
    public EventDispatchChain buildEventDispatchChain(EventDispatchChain tail) {
        return super.buildEventDispatchChain(tail);
    }

    @Override
    public String getTypeSelector() {
        return super.getTypeSelector();
    }

    @Override
    public Styleable getStyleableParent() {
        return super.getStyleableParent();
    }

    @Override
    protected Cursor impl_cssGetCursorInitialValue() {
        return super.impl_cssGetCursorInitialValue();
    }

    @Override
    public Map<StyleableProperty<?>, List<Style>> impl_findStyles(Map<StyleableProperty<?>, List<Style>> styleMap) {
        return super.impl_findStyles(styleMap);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
