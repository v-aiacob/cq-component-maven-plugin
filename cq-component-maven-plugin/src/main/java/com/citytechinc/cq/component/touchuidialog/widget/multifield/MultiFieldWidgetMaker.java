/**
 *    Copyright 2013 CITYTECH, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.citytechinc.cq.component.touchuidialog.widget.multifield;

import com.citytechinc.cq.component.dialog.exception.InvalidComponentFieldException;
import com.citytechinc.cq.component.touchuidialog.TouchUIDialogElement;
import com.citytechinc.cq.component.touchuidialog.exceptions.TouchUIDialogGenerationException;
import com.citytechinc.cq.component.touchuidialog.widget.factory.TouchUIWidgetFactory;
import com.citytechinc.cq.component.touchuidialog.widget.maker.AbstractTouchUIWidgetMaker;
import com.citytechinc.cq.component.touchuidialog.widget.maker.TouchUIWidgetMakerParameters;
import com.citytechinc.cq.component.touchuidialog.widget.textfield.TextFieldWidget;

import java.util.ArrayList;
import java.util.List;

public class MultiFieldWidgetMaker extends AbstractTouchUIWidgetMaker {

    public MultiFieldWidgetMaker(TouchUIWidgetMakerParameters parameters) {
        super(parameters);
    }

    @Override
    public TouchUIDialogElement make() throws ClassNotFoundException, InvalidComponentFieldException, TouchUIDialogGenerationException {

        MultiFieldWidgetParameters widgetParameters = new MultiFieldWidgetParameters();

        widgetParameters.setFieldName(getFieldNameForField());
        widgetParameters.setName(getNameForField());
        widgetParameters.setFieldLabel(getFieldLabelForField());
        widgetParameters.setFieldDescription(getFieldDescriptionForField());
        widgetParameters.setRequired(getRequiredForField());
        widgetParameters.setResourceType(MultiFieldWidget.RESOURCE_TYPE);

        //TODO: See TextFieldWidgetMaker's todos

        TouchUIDialogElement field = TouchUIWidgetFactory.make(parameters, MultiFieldWidget.RANKING);
        field.setFieldName("field");

        List<TouchUIDialogElement> containedElements = new ArrayList<TouchUIDialogElement>();
        containedElements.add(field);

        widgetParameters.setContainedElements(containedElements);

        return new MultiFieldWidget(widgetParameters);
    }

}
