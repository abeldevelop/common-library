package com.abeldevelop.architecture.library.common.factory;

import java.util.List;
import java.util.Optional;

public abstract class CommonFactory<T extends CommonFactoryElement> {

	private final List<T> elements;
	
	protected CommonFactory(List<T> elements) {
		this.elements = elements;
	}
	
	public Optional<T> getElement(String elementName) {
        boolean found = false;
        int index = 0;
        if(elements == null || elements.isEmpty()) {
            return Optional.empty();
        }
        while(index < elements.size() && !found) {
            found = elements.get(index).areYouTheElement(elementName);
            index++;
        }
        if(!found) {
            return Optional.empty();
        } else {
            return Optional.of(elements.get(index-1));
        }
    }
}
