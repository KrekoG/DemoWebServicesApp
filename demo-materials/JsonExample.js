/*
Request:

POST /Quotation/MiscroSoft HTTP/1.0
Host: www.xyz.org

No body, as the parameter is passed in the URL
 */

Response =
/*
HTTP/1.0 200 OK
Content-Type: text/xml; charset = utf-8
Content-Length: nnn
 */
{
    quotation: "Here is the quotation"
};
