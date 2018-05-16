<?php

$xml = <<<XML
<?xml version="1.0"?>
<!DOCTYPE root [
<!ENTITY c PUBLIC "bar" "/etc/passwd">
]>
<root>
    <test>Test</test>
    <sub>&c;</sub>
</root>
XML;

libxml_disable_entity_loader(true);
$dom = new DOMDocument();
$dom->loadXML($xml);

libxml_disable_entity_loader(false); // NOK
foo();
libxml_disable_entity_loader(); // NOK

// Prints Test.
print $dom->textContent;