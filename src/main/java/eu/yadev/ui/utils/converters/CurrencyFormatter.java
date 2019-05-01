package eu.yadev.ui.utils.converters;

import com.vaadin.flow.templatemodel.ModelEncoder;
import eu.yadev.ui.dataproviders.DataProviderUtil;
import eu.yadev.ui.utils.FormattingUtils;

public class CurrencyFormatter implements ModelEncoder<Integer, String> {

	@Override
	public String encode(Integer modelValue) {
		return DataProviderUtil.convertIfNotNull(modelValue, FormattingUtils::formatAsCurrency);
	}

	@Override
	public Integer decode(String presentationValue) {
		throw new UnsupportedOperationException();
	}
}
