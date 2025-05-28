#prueba
from org.csstudio.display.builder.runtime.script import PVUtil

var= widget.getPropertyValue('name')
files=widget.getPropertyValue('file')
widget.getPropertyValue('macros').add('tag',var)
widget.setPropertyValue('file',' ')
widget.setPropertyValue('file',files)